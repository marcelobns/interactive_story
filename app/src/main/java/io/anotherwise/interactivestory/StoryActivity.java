package io.anotherwise.interactivestory;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.anotherwise.interactivestory.model.Page;
import io.anotherwise.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    String name;
    ImageView storyImageView;
    TextView storyTextView;
    Button choice1Button;
    Button choice2Button;

    Story story = new Story();
    Page currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        storyImageView = (ImageView) findViewById(R.id.storyImageView);
        storyTextView = (TextView) findViewById(R.id.storyTextView);

        choice1Button = (Button) findViewById(R.id.choice1Button);
        choice2Button = (Button) findViewById(R.id.choice2Button);

        loadPage(0);
    }

    private void loadPage(int n){
        currentPage = story.getPage(n);

        storyImageView.setImageDrawable(currentPage.getImageDrawable(this));
        storyTextView.setText(String.format(currentPage.getText(), name));

        choice1Button.setText(currentPage.getChoice1().getText());
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPage(currentPage.getChoice1().getNextPage());
            }
        });

        choice2Button.setText(currentPage.getChoice2().getText());
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPage(currentPage.getChoice2().getNextPage());
            }
        });


    }
}
