package com.example.a5101java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        adapter(data());
    }

    ArrayList<MainClass> data() {
        ArrayList<MainClass> mainClasses = new ArrayList<>();
        ArrayList<Story> stories = new ArrayList<>();

        stories.add(new Story(R.drawable.ali, "Alisher"));
        stories.add(new Story(R.drawable.ali, "Alisher"));
        stories.add(new Story(R.drawable.ali, "Alisher"));
        stories.add(new Story(R.drawable.ali, "Alisher"));
        stories.add(new Story(R.drawable.ali, "Alisher"));
        stories.add(new Story(R.drawable.ali, "Alisher"));
        stories.add(new Story(R.drawable.ali, "Alisher"));
        stories.add(new Story(R.drawable.ali, "Alisher"));
        stories.add(new Story(R.drawable.ali, "Alisher"));

        mainClasses.add(new MainClass(stories));

        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));
        mainClasses.add(new MainClass(new Posts(R.drawable.ali, "Alisher Daminov", R.drawable.rasms, "Liked by Alex,James and 7887 others")));

        return mainClasses;
    }

    void adapter(ArrayList<MainClass> list) {
        FeedAdapter feedAdapter = new FeedAdapter(this, list);
        recyclerView.setAdapter(feedAdapter);
    }
}