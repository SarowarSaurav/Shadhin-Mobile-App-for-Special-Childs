package saurav.com.autisticapp;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ActivityParentsCaptureTest {
    @Rule
    public ActivityTestRule<ActivityParentsCapture> mActivityTestRule = new ActivityTestRule<ActivityParentsCapture>(ActivityParentsCapture.class);
    private ActivityParentsCapture mActivity=null ;


    @Before
    public void setUp() throws Exception {
        mActivity= mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch2()
    {
        View view2;
        view2 = mActivity.findViewById(R.id.vCapture);
        assertNotNull(view2);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}