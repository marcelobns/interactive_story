package io.anotherwise.interactivestory.model;

import io.anotherwise.interactivestory.R;

/**
 * Created by marcelobarbosa on 8/24/15.
 */
public class Story {

    private Page[] pages;

    public Story() {
        pages = new Page[7];

        pages[0] = new Page(
                R.drawable.page0,
                "test %1$s",
                new Choice("button 1", 1),
                new Choice("button 2", 2)
        );
    }

    public Page getPage(int n) {
        return pages[n];
    }
}
