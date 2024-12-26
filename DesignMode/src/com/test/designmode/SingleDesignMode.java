package com.test.designmode;

public class SingleDesignMode {
    public static void main(String[] args) {
        System.out.println(SingleEnum.SINGLE_ENUM);
        System.out.println(SingleClass.SINGLE_CLASS);
        System.out.println(Single.getSingle());
        SingleLazy SL = SingleLazy.getSingleLazy();
        SingleLazy SL1 = SingleLazy.getSingleLazy();
        System.out.println(SL == SL1);
    }
}

enum SingleEnum {//枚举实现单例模式
    SINGLE_ENUM;
}

class SingleClass {//老方法，私有构造器通过公开的单例对象实现
    public static final SingleClass SINGLE_CLASS = new SingleClass();

    private SingleClass() {
    }

    @Override
    public String toString() {
        return "SingleClass{}";
    }
}

class Single {//私有构造器，通过公开方法实现单例模式
    private static final Single SINGLE = new Single();

    private Single() {
    }

    public static Single getSingle() {
        return SINGLE;
    }

    @Override
    public String toString() {
        return "Single{}";
    }
}

class SingleLazy {
    private static SingleLazy singleLazy;

    private SingleLazy() {
    }

    public static SingleLazy getSingleLazy() {//有线程问题，
        // 两个同时调用可能会不一样，但是在方法加锁可能会影响性能，所以范围在小一点加锁
        if (singleLazy == null){//提升效率
            synchronized (SingleLazy.class) {//为了安全
                if (singleLazy == null) {
                    return singleLazy = new SingleLazy();
                } else {
                    return singleLazy;
                }
            }
        }
        else return singleLazy;
    }
}
