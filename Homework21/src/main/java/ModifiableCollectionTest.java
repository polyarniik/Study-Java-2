import collections.my.ModifiableCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModifiableCollectionTest {
    private ModifiableCollection<Integer> coll;


    @Before
    public void init() {
        this.coll = new ModifiableCollection<Integer>();
        coll.add(-1);
        coll.add(0);
        coll.add(1);
        coll.add(2);
    }

    @Test
    public void testSize() {
        Assert.assertEquals(4, coll.size());
    }

    @Test
    public void testAddNull() {
        Assert.assertTrue(coll.add(null));
    }

    @Test
    public void testAdd() {
        Assert.assertTrue(coll.add(78));
        Assert.assertEquals(5, coll.size());
    }

    @Test
    public void testIteratorHasNext() {
        Assert.assertTrue(coll.iterator().hasNext());
        Assert.assertTrue(coll.iterator().hasNext());
    }

    @Test
    public void testRemove() {
        coll.iterator().remove();
        Assert.assertEquals(3, coll.size());
    }

    @Test
    public void testEquals() {
        ModifiableCollection<Integer> newColl = new ModifiableCollection<Integer>();
        newColl.add(-1);
        newColl.add(0);
        newColl.add(1);
        newColl.add(2);
        Assert.assertTrue(coll.equals(newColl));
    }


    @Test
    public void testNotEquals() {
        ModifiableCollection<Integer> newColl = new ModifiableCollection<Integer>();
        newColl.add(-1);
        newColl.add(0);
        newColl.add(2);
        newColl.add(1);
        Assert.assertFalse(coll.equals(newColl));
    }
}
