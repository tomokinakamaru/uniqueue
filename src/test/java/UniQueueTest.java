import com.github.tomokinakamaru.uniqueue.UniQueue;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@SuppressWarnings("AssertWithSideEffects")
final class UniQueueTest {

  @Test
  void test1() {
    UniQueue<String> q = new UniQueue<>();
    assert q.add("a");
    assert !q.add("a");
    assert q.peek() != null;
    assert q.peek().equals("a");
    assert q.size() == 1;
    assert q.contains("a");
    assert q.element().equals("a");
    assert q.remove().equals("a");
    assert q.poll() == null;
    assert q.isEmpty();
    assert !q.add("a");
    assert q.offer("b");
    assert q.remove("b");
  }

  @Test
  void test2() {
    UniQueue<String> q = new UniQueue<>(Arrays.asList("a", "b"));
    assert !q.addAll(Arrays.asList("a", "b"));
    assert q.addAll(Arrays.asList("b", "c"));
    assert q.size() == 3;
    assert q.containsAll(Arrays.asList("a", "b", "c"));
    assert q.removeAll(Arrays.asList("a", "b"));
    assert q.size() == 1;
    assert q.retainAll(Arrays.asList("a", "b"));
    assert q.size() == 0;
  }

  @Test
  void test3() {
    UniQueue<Integer> q = new UniQueue<>(Arrays.asList(1, 2));
    assert q.iterator().hasNext();
    assert q.toArray().length == 2;

    Integer[] arr = new Integer[] {};
    assert q.toArray(arr).length == 2;
  }

  @Test
  void test4() {
    UniQueue<Integer> q = new UniQueue<>();
    q.add(1);
    q.clear();
    q.add(1);
    assert q.size() == 0;
  }
}
