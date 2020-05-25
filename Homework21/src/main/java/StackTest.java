import homework.february.two.mystack.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    private Stack stack;
    @Before
    public void init() {
        stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
    }

    @Test
    public void testSize() {
        Assert.assertEquals(4, stack.size());
    }

    @Test
    public void testAdd() {
        stack.add(5);
        Assert.assertEquals(5, stack.peek());
    }

    @Test
    public void testPeek() {
        Assert.assertEquals(4, stack.peek());
        Assert.assertEquals(4, stack.peek());
    }

    @Test
    public void testPopTrue() {
        Assert.assertEquals(4, stack.pop());
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
    }

    @Test
    public void testPopFalse() {
        Assert.assertEquals(4, stack.pop());
        Assert.assertNotEquals(4, stack.pop());
        Assert.assertEquals(2, stack.pop());
    }
}

