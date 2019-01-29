package com.example.meitong.dataanalysis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PieChart mPieChart;
    BarChart barChart;
    LineChart mLineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLineChart = (LineChart) findViewById(R.id.lineChart);
        mPieChart = findViewById(R.id.spread_pie_chart);
        barChart = findViewById(R.id.barChart);

        //设置数据
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(10, 2));
        entries.add(new Entry(20, 10));
        //一个LineDataSet就是一条线
        LineDataSet lineDataSet = new LineDataSet(entries, "温度");
        LineData data = new LineData(lineDataSet);
        mLineChart.setData(data);

        ArrayList<String> xValues = new ArrayList<String>(); //用来表示每个饼块上的内容
        String[]  content = new String[] {"<10", "10~20", "21~40", ">40"};
        for (int i = 0; i < 4; i++) {
            xValues.add("年龄("+content[i]+")");
        }

        List<PieEntry> yValue = new ArrayList<PieEntry>(); //用来表示封装每个饼块的实际数据

        List<Float> qs = new ArrayList<Float>();
        qs.add(14f);
        qs.add(14f);
        qs.add(34f);
        qs.add(38f);
        for (int i = 0; i < qs.size(); i++) {
            yValue.add(new PieEntry(qs.get(i), xValues.get(i)));
        }

        PieDataSet pieDataSet = new PieDataSet(yValue, "2015浏览量统计");

        pieDataSet.setSliceSpace(2f);

        PieData pieData = new PieData(pieDataSet);
        mPieChart.setUsePercentValues(true); //显示百分比
        mPieChart.setData(pieData);

        //设置数据
        List<BarEntry> yEntries = new ArrayList<>();

        yEntries.add(new BarEntry(10, 2));
        yEntries.add(new BarEntry(20, 10));
        //一个LineDataSet就是一条线
        BarDataSet barDataSet = new BarDataSet(yEntries, "违章");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);


    }


}
