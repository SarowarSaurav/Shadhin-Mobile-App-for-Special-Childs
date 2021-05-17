package saurav.com.autisticapp;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import saurav.com.autisticapp.Game2.GameEye2;

import static org.junit.Assert.assertNotNull;

public class GameEye2Test {
    @Rule
    public ActivityTestRule<GameEye2> mActivityTestRule = new ActivityTestRule<GameEye2>(GameEye2.class);
    private GameEye2 mActivity=null ;


    @Before
    public void setUp() throws Exception {
        mActivity= mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch2()
    {
        View view2;
        view2 = mActivity.findViewById(R.id.ey2);
        assertNotNull(view2);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}