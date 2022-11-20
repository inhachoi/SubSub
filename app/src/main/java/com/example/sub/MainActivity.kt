package com.example.sub

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.red
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

        lateinit var pieChart: PieChart

        lateinit var barChart: BarChart
        lateinit var barData: BarData
        lateinit var barDataSet: BarDataSet
        lateinit var barEntriesList: ArrayList<BarEntry>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // on below line we are initializing our
            // variable with their ids.
            pieChart = findViewById(R.id.pieChart)

            // on below line we are setting user percent value,
            // setting description as enabled and offset for pie chart
            pieChart.setUsePercentValues(true)
            pieChart.getDescription().setEnabled(false)
            pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

            // on below line we are setting drag for our pie chart
            pieChart.setDragDecelerationFrictionCoef(0.95f)

            // on below line we are setting hole
            // and hole color for pie chart
            pieChart.setDrawHoleEnabled(true)
            pieChart.setHoleColor(Color.WHITE)

            // on below line we are setting circle color and alpha
            pieChart.setTransparentCircleColor(Color.WHITE)
            pieChart.setTransparentCircleAlpha(110)

            // on  below line we are setting hole radius
            pieChart.setHoleRadius(58f)
            pieChart.setTransparentCircleRadius(61f)

            // on below line we are setting center text
            pieChart.setDrawCenterText(true)

            // on below line we are setting
            // rotation for our pie chart
            pieChart.setRotationAngle(0f)

            // enable rotation of the pieChart by touch
            pieChart.setRotationEnabled(true)
            pieChart.setHighlightPerTapEnabled(true)

            // on below line we are setting animation for our pie chart
            pieChart.animateY(1400, Easing.EaseInOutQuad)

            // on below line we are disabling our legend for pie chart
            pieChart.legend.isEnabled = false
            pieChart.setEntryLabelColor(Color.WHITE)
            pieChart.setEntryLabelTextSize(9f)

            // on below line we are creating array list and
            // adding data to it to display in pie chart
            val entries: ArrayList<PieEntry> = ArrayList()
            entries.add(PieEntry(25f))
            entries.add(PieEntry(35f))
            entries.add(PieEntry(20f))
            entries.add(PieEntry(10f))
            entries.add(PieEntry(10f))

            // on below line we are setting pie data set
            val dataSet = PieDataSet(entries, "Mobile OS")

            // on below line we are setting icons.
            dataSet.setDrawIcons(false)

            // on below line we are setting slice for pie
            dataSet.sliceSpace = 3f
            dataSet.iconsOffset = MPPointF(0f, 40f)
            dataSet.selectionShift = 5f

            // add a lot of colors to list
            val colors: ArrayList<Int> = ArrayList()
            colors.add(resources.getColor(R.color.yellow))
            colors.add(resources.getColor(R.color.purple_200))
            colors.add(resources.getColor(R.color.red))
            colors.add(resources.getColor(R.color.green))
            colors.add(resources.getColor(R.color.blue))

            // on below line we are setting colors.
            dataSet.colors = colors

            // on below line we are setting pie data set
            val data = PieData(dataSet)
            data.setValueFormatter(PercentFormatter())
            data.setValueTextSize(10f)
            data.setValueTypeface(Typeface.DEFAULT_BOLD)
            data.setValueTextColor(Color.WHITE)
            pieChart.setData(data)

            // undo all highlights
            pieChart.highlightValues(null)

            // loading chart
            pieChart.invalidate()





            // 바차트************************************************************************************
            barChart = findViewById(R.id.barChart)

            // on below line we are calling get bar
            // chart data to add data to our array list
            getBarChartData()

            // on below line we are initializing our bar data set
            barDataSet = BarDataSet(barEntriesList, "Bar Chart Data")

            // on below line we are initializing our bar data
            barData = BarData(barDataSet)

            // on below line we are setting data to our bar chart
            barChart.data = barData

            // on below line we are setting colors for our bar chart text
            barDataSet.valueTextColor = Color.BLACK

            // on below line we are setting color for our bar data set
            barDataSet.setColor(resources.getColor(R.color.blue))

            // on below line we are setting text size
            barDataSet.valueTextSize = 10f

            // on below line we are enabling description as false
            barChart.description.isEnabled = false



            btn_to_login.setOnClickListener(){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            btn_to_mysub.setOnClickListener(){
                val intent = Intent(this, MysubActivity::class.java)
                startActivity(intent)
            }
            btn_to_board.setOnClickListener(){
                val intent = Intent(this, BoardActivity::class.java)
                startActivity(intent)
            }



        }
    private fun getBarChartData() {
        barEntriesList = ArrayList()

        // on below line we are adding data
        // to our bar entries list
        barEntriesList.add(BarEntry(1f, 2f))
        barEntriesList.add(BarEntry(2f, 4f))
        barEntriesList.add(BarEntry(3f, 3f))
        barEntriesList.add(BarEntry(4f, 2f))
        barEntriesList.add(BarEntry(5f, 5f))

    }
}