package com.example.fibonacciseries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FibonacciAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fibonacciNumbers = generateFibonacci(100)
        adapter = FibonacciAdapter(fibonacciNumbers)
        recyclerView.adapter = adapter
    }

    private fun generateFibonacci(count: Int): List<Int> {
        val fibNumbers = mutableListOf<Int>()
        if (count > 0) fibNumbers.add(0)
        if (count > 1) fibNumbers.add(1)
        for (i in 2 until count) {
            val nextNumber = fibNumbers[i - 1] + fibNumbers[i - 2]
            fibNumbers.add(nextNumber)
        }
        return fibNumbers
    }
}

class FibonacciAdapter(private val fibonacciNumbers: List<Int>) :
    RecyclerView.Adapter<FibonacciAdapter.FibonacciViewHolder>() {
    inner class FibonacciViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FibonacciViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fibonacci_item, parent, false)
        return FibonacciViewHolder(view)
    }

    override fun onBindViewHolder(holder: FibonacciViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.fibonacci_number).text = fibonacciNumbers[position].toString()
    }

    override fun getItemCount(): Int {
        return fibonacciNumbers.size
    }
}