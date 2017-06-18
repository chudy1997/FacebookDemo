package chudy1997;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.LinkedList;
import static org.mockito.Mockito.when;

/**
 * FacebookServiceImpl's testclass
 * Created by Karol on 2017-06-18.
 */
public class FacebookServiceImplTest {
    @Test
    public void testFindByIdPositive() throws Exception {
        FacebookServiceImpl fsi = Mockito.mock(FacebookServiceImpl.class);
        Facebook prof1 = Mockito.mock(Facebook.class);
        Facebook prof2 = Mockito.mock(Facebook.class);
        when(prof1.getId()).thenReturn("1");
        when(prof2.getId()).thenReturn("2");
        LinkedList<Facebook> lista = new LinkedList<>();
        lista.add(prof1);
        lista.add(prof2);
        when(fsi.getProfiles()).thenReturn(lista);
        when(fsi.findById("1")).thenCallRealMethod();

        Assert.assertEquals(fsi.findById("1").getId(), "1");
    }

    @Test(expected = NotFoundException.class)
    public void testFindByIdNegative() throws Exception {
        FacebookServiceImpl fsi = Mockito.mock(FacebookServiceImpl.class);
        Facebook prof1 = Mockito.mock(Facebook.class);
        Facebook prof2 = Mockito.mock(Facebook.class);
        when(prof1.getId()).thenReturn("1");
        when(prof2.getId()).thenReturn("2");
        LinkedList<Facebook> lista = new LinkedList<>();
        lista.add(prof1);
        lista.add(prof2);
        when(fsi.getProfiles()).thenReturn(lista);
        when(fsi.findById("3")).thenCallRealMethod();

        fsi.findById("3");
    }

    @Test
    public void testFindMostCommonWords() throws Exception {
        FacebookServiceImpl fsi = Mockito.mock(FacebookServiceImpl.class);
        Facebook prof1 = Mockito.mock(Facebook.class);
        Facebook prof2 = Mockito.mock(Facebook.class);
        LinkedList<Facebook.PostsBean> posts1 = new LinkedList<>();
        LinkedList<Facebook.PostsBean> posts2 = new LinkedList<>();
        LinkedList<Facebook> lista = new LinkedList<>();
        lista.add(prof1);
        lista.add(prof2);
        posts1.add(new Facebook.PostsBean("45", "Summer is coming"));
        posts1.add(new Facebook.PostsBean("54", "Summer is leaving"));
        posts2.add(new Facebook.PostsBean("36", "Winter is coming"));
        posts2.add(new Facebook.PostsBean("63", "Winter is leaving"));
        when(prof1.getId()).thenReturn("1");
        when(prof2.getId()).thenReturn("2");
        when(prof1.getPosts()).thenReturn(posts1);
        when(prof2.getPosts()).thenReturn(posts2);
        when(fsi.getProfiles()).thenReturn(lista);
        when(fsi.findMostCommonWords()).thenCallRealMethod();

        Assert.assertEquals(4L, (long) fsi.findMostCommonWords().get("is"));
        Assert.assertEquals(2L, (long) fsi.findMostCommonWords().get("Summer"));
    }

    @Test
    public void testFindPostIdsByKeyword() throws Exception {
        FacebookServiceImpl fsi = Mockito.mock(FacebookServiceImpl.class);
        Facebook prof1 = Mockito.mock(Facebook.class);
        Facebook prof2 = Mockito.mock(Facebook.class);
        LinkedList<Facebook.PostsBean> posts1 = new LinkedList<>();
        LinkedList<Facebook.PostsBean> posts2 = new LinkedList<>();
        LinkedList<Facebook> lista = new LinkedList<>();
        lista.add(prof1);
        lista.add(prof2);
        posts1.add(new Facebook.PostsBean("45", "Summer is coming"));
        posts1.add(new Facebook.PostsBean("54", "Summer is leaving"));
        posts2.add(new Facebook.PostsBean("36", "Winter is coming"));
        posts2.add(new Facebook.PostsBean("63", "Winter is leaving"));
        when(prof1.getId()).thenReturn("1");
        when(prof2.getId()).thenReturn("2");
        when(prof1.getPosts()).thenReturn(posts1);
        when(prof2.getPosts()).thenReturn(posts2);
        when(fsi.getProfiles()).thenReturn(lista);
        when(fsi.findPostIdsByKeyword("coming")).thenCallRealMethod();

        Assert.assertTrue(fsi.findPostIdsByKeyword("coming").contains("45"));
        Assert.assertFalse(fsi.findPostIdsByKeyword("coming").contains("54"));
    }

    @Test
    public void testFindAll() throws Exception {
        FacebookServiceImpl fsi = Mockito.mock(FacebookServiceImpl.class);
        Facebook prof1 = Mockito.mock(Facebook.class);
        Facebook prof2 = Mockito.mock(Facebook.class);
        LinkedList<Facebook> lista = new LinkedList<>();
        lista.add(prof1);
        lista.add(prof2);
        when(fsi.findAll()).thenCallRealMethod();
        when(prof1.getId()).thenReturn("1");
        when(prof2.getId()).thenReturn("2");
        when(prof1.compareTo(prof2)).thenReturn(-1);
        when(prof2.compareTo(prof1)).thenReturn(1);
        when(fsi.getProfiles()).thenReturn(lista);

        Assert.assertTrue(prof1.getId().equals(fsi.findAll().toArray(new Facebook[2])[0].getId()));
    }

}