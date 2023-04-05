package com.java8的新特性;



import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/11/2 21:28
 *
 *
 * ① Stream 自己不会存储元素。
 *
 * ② Stream 不会改变源对象。相反，他们会返回一个持有结果的新 Stream。
 *
 * ③ Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *
 * 一个中间操作链，对数据源的数据进行处理
 * 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 *
 * 3.1.1 创建方式一：通过集合
 * Java 8的 Collection 接口被扩展，提供了两个获取流的方法：
 *
 * default Stream\<E> stream() : 返回一个顺序流
 * default Stream\<E> parallelStream() : 返回一个并行流
 *
 * 3.1.2 创建方式二：通过数组
 * Java 8中的 Arrays 的静态方法 stream() 可以获取数组流
 *
 * 调用 Arrays 类的 static\<T> Stream\<T> stream(T[] array): 返回一个流
 * 重载形式，能够处理对应基本类型的数组：
 *
 * public static IntStream stream（int[] array）
 * public static LongStream stream（long[] array）
 * public static DoubleStream stream（double[] array）
 *
 *
 *
 * 3.1.3 创建方式三：通过Stream的of()方法
 * 可以调用Stream类静态方法of()，通过显示值创建一个流。可以用于接收任意数量的参数
 *
 * public static \<T>Stream\<T> of(T...values):返回一个流
 *
 * 3.1.4 创建方式四：创建无限流
 *
 * 迭代: public static\<T> Stream\<T> iterate(final T seed, final UnaryOperator\<T> f)
 * 生成: public static\<T> Stream\<T> generate(Supplier\<T> s)
 *
 *
 */
public class StreamAPITest1 {

    //创建 Stream方式一：通过集合
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //efault Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //创建 Stream方式二：通过数组
    public void test2() {
        int[] arrs = {1, 2, 3, 6, 2};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arrs);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] employees = {e1, e2};
        Stream<Employee> stream1 = Arrays.stream(employees);
    }

    //创建 Stream方式三：通过Stream的of()
    public void test3() {
        Stream<Integer> integerStream = Stream.of(12, 34, 45, 65, 76);
    }

    //创建 Stream方式四：创建无限流
    public void test4() {

        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}

