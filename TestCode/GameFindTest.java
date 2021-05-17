package saurav.com.autisticapp;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import saurav.com.autisticapp.Game.GameFind;

import static org.junit.Assert.assertNotNull;

public class GameFindTest {
    @Rule
    public ActivityTestRule<GameFind> mActivityTestRule = new ActivityTestRule<GameFind>(GameFind.class);
    private GameFind mActivity=null ;


    @Before
    public void setUp() throws Exception {
        mActivity= mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch()
    {
        View view2;
        view2 = mActivity.findViewById(R.id.find);
        assertNotNull(view2);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}