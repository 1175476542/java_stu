package com.test.testclass;

public class TestClass {
    public static void main(String[] args) {
        Sentence s  = new Sentence();
        s.printOut();
        Ssxy ssxy1 = new Ssxy();
        ssxy1.printOut();
        Ssxy ssxy2 = new Ssxy("四库全书");
        ssxy2.printOut();
        Ssxy ssxy3 = new Ssxy(12);
        ssxy3.printOut();
        Ssxy ssxy4 = new Ssxy("四库全书",12);
        ssxy4.printOut();
        ssxy1.getName();
        ssxy1.printOut();
        ssxy1.getPage();
        ssxy1.printOut();
        ssxy1.setPage(15);
        ssxy1.printOut();
        ssxy1.setName("三国演义");
        ssxy1.printOut();
    }
}
class Ssxy{
    private String name = "《世说新语》";
    private int page = 500;

    public Ssxy() {
    }

    public Ssxy(String name) {
        this.name = name;
    }

    public Ssxy(int page) {
        this.page = page;
    }
    public Ssxy(String name,int page) {
        this.name = name;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public int getPage() {
        return page;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void printOut(){
        System.out.println(this.name + this.page);
    }
}
class Pinzao extends Ssxy{

    public Pinzao(){

    }
    public Pinzao(String name){
        this.name = name;
    }

    public Pinzao(int page){
        this.page = page;
    }
    public Pinzao(String name,int page){
        this.name = name;
        this.page = page;
    }
    private int page = 100;
    private String name = "《品藻》";
    public String getName(){
        return this.name;
    }
    public int getpage(){
        return this.page;
    }
    public void setName(String name){
        this.name = name;
    }
    public void page(int page){
        this.page = page;
    }
    public void printOut(){
        System.out.println("《世说新语》下的" + name);
    }
}
class Sentence extends Pinzao{
    public Sentence(){

    }
    public Sentence(int pageIndex){
        this.pageIndex = pageIndex;
    }
    public Sentence(String content){
        this.content = content;
    }

    public Sentence(int pageIndex,String content){
        this.pageIndex = pageIndex;
        this.content = content;
    }

    private int pageIndex = 5;
    private String content = "我与我周旋，宁做我";


    public int getPage(){
        return this.pageIndex;
    }
    public String getContent(){
        return this.content;
    }
    public void setPage(int pageIndex){
        this.pageIndex = pageIndex;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void printOut(){
        System.out.println("《世说新语》下的" + getName()+ "下的：" + this.content);
    }
}
