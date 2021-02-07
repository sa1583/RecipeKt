package com.example.recipekt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipekt.databinding.ActivityDishDetailBinding
import com.example.recipekt.databinding.ActivityMainBinding

class DishDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDishDetailBinding

    // val TAG = "ListActivity"
    lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDishDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGredientList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvGredientList.setHasFixedSize(true)

        val recyclerAdapter = GredientsAdapter()
        binding.rvGredientList.adapter = recyclerAdapter


        db = AppDatabase.getInstance(this)!!

        // 새 레시피 생성
        if (intent.getIntExtra("isNew", 0) == 1) {
            binding.dishName.visibility = View.INVISIBLE
            binding.btnModify.visibility = View.INVISIBLE
            binding.btnDelete.visibility = View.INVISIBLE

        }
        // 기존 레시피 수정
        else {
            binding.inputDishName.visibility = View.INVISIBLE
            binding.btnSave.visibility = View.INVISIBLE
            binding.btnCancle.visibility = View.INVISIBLE
            val dishName = intent.getStringExtra("dishName").toString()
            // 이미지 받기(미완)
            //dishImage = intent.getByteArrayExtra(("dishImage").toString()
            binding.dishName.text = dishName
            recyclerAdapter.update(loadRecipe(dishName))
        }


        // 스피너 설정
        val data = resources.getStringArray(R.array.spinner)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        binding.spinGredientUnit.adapter = adapter

        var addName: String
        var addAmount: Int
        var addUnit: String = data[0]

        binding.spinGredientUnit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                addUnit = data[position]
            }

        }


        //재료 추가 버튼
        binding.btnAddGredient.setOnClickListener {
            var errorMsg = ""
            if (binding.etGredientName.text.isEmpty())
                errorMsg += "재료 이름을 입력해 주세요\n"
            if (binding.etGredientAmount.text.isEmpty())
                errorMsg += "재료 양을 입력해 주세요"
            if (errorMsg.isNotEmpty()) {
                binding.tvError.visibility = View.VISIBLE
                binding.tvError.text = errorMsg
            }
            else {
                addName = binding.etGredientName.text.toString()
                addAmount = binding.etGredientAmount.text.toString().toInt()
                recyclerAdapter.update(recyclerAdapter.gredients + Gredient(addName, addAmount, addUnit))
                binding.rvGredientList.adapter = recyclerAdapter
                initializeAddGredient()
            }
        }

        // 저장 버튼
        binding.btnSave.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val dbRecipe = DBRecipe(binding.inputDishName.text.toString(), binding.dishImage.toString())
            val dbGredients = mutableListOf<DBGredient>()
            for (g in recyclerAdapter.gredients) dbGredients.add(DBGredient(dbRecipe.name, g.name, g.Amount, g.Unit))
            db.RecipeDAO().insertRecipe(dbRecipe)
            for (dbG in dbGredients) db.RecipeDAO().insertGredients(dbG)
            startActivity(intent)
        }

        // 수정 버튼
        binding.btnModify.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val dbGredients = mutableListOf<DBGredient>()
            for (g in recyclerAdapter.gredients) dbGredients.add(DBGredient(binding.dishName.text.toString(), g.name, g.Amount, g.Unit))
            // update는 db에 이미 있는 항목만 수정, 추가 삭제를 구현해야 하니까 update말고 다른거 써야할듯
            for (dbG in dbGredients) db.RecipeDAO().updateRecipe(dbGredients)
            startActivity(intent)
        }

        // 삭제 버튼
        binding.btnDelete.setOnClickListener {
            val dishName = binding.dishName.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            val dbRecipe: DBRecipe = db.RecipeDAO().getRecipe(dishName)
            db.RecipeDAO().getGredient(dishName)
            for (dbG in db.RecipeDAO().getGredient(dishName)) db.RecipeDAO().deleteGredient(dbG)
            db.RecipeDAO().deleteRecipe(dbRecipe)
            startActivity(intent)
        }
    }


    private fun initializeAddGredient() {
        binding.etGredientName.setText(null)
        binding.etGredientAmount.setText(null)
        binding.spinGredientUnit.setSelection(0)
    }

    // 데이터 베이스에서 해당 레시피의 재료목록 불러오기
    private fun loadRecipe(dishName: String) = db.RecipeDAO().getGredient(dishName).map {
        Gredient(it.gredientName, it.gredientAmount, it.gredientUnit)
    }
}