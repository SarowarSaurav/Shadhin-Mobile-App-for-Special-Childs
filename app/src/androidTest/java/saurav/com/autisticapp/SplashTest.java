package saurav.com.autisticapp;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SplashTest {
    @Rule
    public ActivityTestRule<Splash> mActivityTestRule = new ActivityTestRule<Splash>(Splash.class);
    private Splash mActivity=null ;


    @Before
    public void setUp() throws Exception {
        mActivity= mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch2()
    {
        View view2;
        view2 = mActivity.findViewById(R.id.vSplash);
        assertNotNull(view2);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}