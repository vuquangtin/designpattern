package designpatterns.gof.book.inline;

import java.util.List;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;
import designpatterns.gof.book.inline.RandomUtils.IdPattern;

/**
 * <h1>Template Method</h1> Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức
 * năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. Mẫu Template
 * Method cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà
 * không phải thay đổi cấu trúc thuật toán. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.TemplateMethod, description = "模板方法")
public class TemplateMethodPattern implements DesignPatternClient {

  private abstract class Application {
    private List<Document> documents = Lists.newArrayList();

    public void addDocument(Document document) {
      documents.add(document);
    }

    public void openDocument(String docName) {
      if (!canOpenDocument(docName)) {
        System.out.println("无法打开文件: " + docName);
        return;
      }

      Document document = doCreateDocument(docName);
      if (document != null) {
        addDocument(document);

        aboutToOpenDocument(document);
        document.open();
        document.doRead();
        document.save();
        document.close();
      }
    }

    protected abstract Document doCreateDocument(String docName);

    protected abstract boolean canOpenDocument(String docName);

    protected abstract void aboutToOpenDocument(Document document);
  }

  private class DrawApplication extends Application {
    @Override
    protected Document doCreateDocument(String docName) {
      return new DrawDocument(docName);
    }

    @Override
    protected boolean canOpenDocument(String docName) {
      return RandomUtils.nextBoolean();
    }

    @Override
    protected void aboutToOpenDocument(Document document) {
      System.out.println("About: " + document);
    }
  }

  private class SpreadsheetApplication extends Application {

    @Override
    protected Document doCreateDocument(String docName) {
      return new SpreadsheetDocument(docName);
    }

    @Override
    protected boolean canOpenDocument(String docName) {
      return RandomUtils.nextBoolean();
    }

    @Override
    protected void aboutToOpenDocument(Document document) {
    }
  }

  private abstract class Document {
    protected String docName;

    public Document(String docName) {
      this.docName = docName;
    }

    public void open() {
      /** 可以反映子类的调用情况 */
      System.out.println("open " + this.toString());
    }

    public void close() {
      System.out.println("close " + this.toString());
    }

    public void save() {
      System.out.println("save " + this.toString());
    }

    protected abstract void doRead();
  }

  private class DrawDocument extends Document {

    public DrawDocument(String docName) {
      super(docName);
    }

    @Override
    public void doRead() {
      System.out.println("DrawDocument#doRead");
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).omitNullValues().add("docName", docName).toString();
    }
  }

  private class SpreadsheetDocument extends Document {

    public SpreadsheetDocument(String docName) {
      super(docName);
    }

    @Override
    public void doRead() {
      System.out.println("SpreadsheetDocument#doRead");
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).omitNullValues().add("docName", docName).toString();
    }
  }

  @Override
  public void usage() {
    String docName = RandomUtils.nextId(IdPattern.UpperCase);

    Application application = new DrawApplication();
    application.openDocument(docName);

    System.out.println();
    application = new SpreadsheetApplication();
    application.openDocument(docName);
  }

  public static void main(String[] args) {
    new TemplateMethodPattern().usage();
  }

}
