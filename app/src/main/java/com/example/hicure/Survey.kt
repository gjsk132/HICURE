package com.example.hicure

import android.content.Intent
import android.os.Bundle
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hicure.databinding.ActivitySurveyBinding

class Survey : AppCompatActivity() {

    val binding: ActivitySurveyBinding by lazy { ActivitySurveyBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data: MutableList<QuestionMemo> = loadData()
        var adapter = CustomAdapter()
        adapter.listData = data
        binding.questionView.adapter = adapter

        binding.questionView.layoutManager = LinearLayoutManager(this)

        "오늘의 폐건강".also { binding.actionTitle.text = it }

        binding.actionTitle.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.actionTitle.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val actionTextWidth = binding.actionTitle.width

                binding.actionTitle.width = actionTextWidth + 10

                // binding.mainText.text = "$actionTextWidth"

                val layoutParams = binding.behindTitle.layoutParams
                layoutParams.width = actionTextWidth + 30
                binding.behindTitle.layoutParams = layoutParams

            }
        })

        binding.checkButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.surveyTitle.text = "만족도조사"
    }

    private fun loadData(): MutableList<QuestionMemo> {
        val data: MutableList<QuestionMemo> = mutableListOf()

        val surveyQuestion = listOf(
            "기기가 제대로 작동하였나요?",
            "기기 사용에 어려움은 없었나요?"
        )

        surveyQuestion.forEachIndexed { index, title ->
            val no = index + 1
            val memo = QuestionMemo(no, title)
            data.add(memo)
        }
        return data;
    }
}