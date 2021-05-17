package saurav.com.autisticapp;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import saurav.com.autisticapp.Expression.ExpressionShow;

import static org.junit.Assert.assertNotNull;

public class ExpressionShowTest {
    @Rule
    public ActivityTestRule<ExpressionShow> mActivityTestRule = new ActivityTestRule<ExpressionShow>(ExpressionShow.class);
    private ExpressionShow mActivity=null ;


    @Before
    public void setUp() throws Exception {
        mActivity= mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchError1()
    {
        View view2;
        view2 = mActivity.findViewById(R.id.vShow);
        assertNotNull(view2);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}