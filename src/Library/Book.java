package Library;


public class Book {
    private String title;
    private int pageCount;


    public Book(String title, int pageCount){
        if(title == null) {
            throw new IllegalArgumentException("title canot be empty");
        }
        this.title = title;
        if(pageCount <= 0){
            throw new IllegalArgumentException("page count must be positive");
        }
        this.pageCount = pageCount;
    }


    public int getPageCount(){
        return this.pageCount;
    }


    public String getTitle(){
        return this.title;
    }


    @Override
    public String toString(){
        return this.title + "("+ this.pageCount+")";

    }
}
