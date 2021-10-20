package com.ahmed.rxjavaapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHi)
    TextView txtHi;
    @BindView(R.id.myRecyclerView)
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RVCustomAdapter rvCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        rvCustomAdapter = new RVCustomAdapter();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rvCustomAdapter);


//        Observable.just("How are you?").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//
//                txtHi.setText(s);
//
//            }
//        });
        Observable.just("How are you?").subscribe(s -> txtHi.setText(s));

//
//        Observable.just("Morteza", "Monica", "Doey", "Ross", "Jack").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//            rvCustomAdapter.addStringToList(s);
//            }
//        });

                Entry entry1 = new Entry("PS4", BigDecimal.valueOf(1500), new Date());
        Entry entry2 = new Entry("Xbox One", BigDecimal.valueOf(2000), new Date());
        Entry entry3 = new Entry("Xbox One s", BigDecimal.valueOf(2500), new Date());
        Entry entry4 = new Entry("XBox One X", BigDecimal.valueOf(3000), new Date());

//        Observable.just(entry1, entry2, entry3, entry4).subscribe(new Consumer<Entry>() {
//            @Override
//            public void accept(Entry entry) throws Exception {
//
//                rvCustomAdapter.addEntry(entry);
//            }
//        });

        Observable.just(entry1, entry2, entry3, entry4).subscribe(entry -> rvCustomAdapter.addEntry(entry));


    }
}












