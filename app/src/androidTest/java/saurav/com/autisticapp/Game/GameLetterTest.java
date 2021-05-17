package saurav.com.autisticapp.Game;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import saurav.com.autisticapp.R;

import static org.junit.Assert.assertNotNull;

public class GameLetterTest {
    @Rule
    public ActivityTestRule<GameLetter> mActivityTestRule = new ActivityTestRule<GameLetter>(GameLetter.class);
    private GameLetter mActivity=null ;


    @Before
    public void setUp() throws Exception {
        mActivity= mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchError2()
    {
        View view2;
        view2 = mActivity.findViewById(R.id.letter);
        assertNotNull(view2);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}