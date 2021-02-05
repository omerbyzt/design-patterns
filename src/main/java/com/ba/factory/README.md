# Factory Design Pattern
> _**Factory Design Pattern, Creational Design Pattern grubunda yer alır.**_
>
> Oluşturduğumuz bir interface ya da abstract sınıftan türeterek başka bir sınıf oluşturma işlemine Factory Pattern denir.Bu pattern aynı özelliği kullanmak isteyen sınıflar tarafından kullanılır.

&NewLine;

Daha somut bir örnek ile açıklayalım.

Öncelikle verdiğimiz datayı, seçtiğimiz bir dosya türünde return eden bir kod yazmak istiyoruz.

* İlk olarak sınıflarımızın implement edeceği interface'imizi yazarak başlıyoruz.


    public interface FileExporter {
      String export(String content);
    }

* PDF ve EXCEL çıktısını verecek 2 farklı sınıf yazacağız ve bu sınıflar yazdığımız interface'i impelemt edecekler.

PdfExporter

    class PdfExporter implements FileExporter{
      @Override
      public String export(String content) {
          return "PDF -> " + content;
      }
    }

ExcelExporter

    class ExcelExporter implements FileExporter{
        @Override
        public String export(String content) {
            return "EXCEL -> " + content;
        }
    }

* Buradaki bir önemli nokta ise class'larımızın 'Access Modifiers' olarak public tanımlanmamasıdır. Buradaki amacımız son kullanıcının, kullanılan metodların nasıl oluşturulduğunu görmesine gerek olmamasıdır.

* Farklı bir paketten factory pattern'imizi kullanacak olan kişinin sadece istediği metoda erişmesini, bizim bu yapıda bu işlemleri nasıl yaptığımızla ilgilenmemesini sağlarız.

* Şimdi sıra factory metodumuzu yazmaya geldi.


    public class FileExporterFactory {

        public static FileExporter getInstance(FileType fileType){
            switch (fileType){
                case EXCEL: return new ExcelExporter();
                case PDF: return new PdfExporter();
                default: throw new UnsupportedOperationException();
            }
        }

        public enum FileType {
            PDF,
            EXCEL;
        }
    }

* Bu kodda öncelikle dosya türlerimizi **enum** olarak tanımladık.

* Ardından **getInstance** adında, **FileExporter** return eden bir metod oluşturup parametre olarak çıktısını istediğimiz dosya türünü verdik.

* **getInstance** içerisinde gelen parametre değerine göre işlemi yapacak class'ın instance'ını oluşturduk.


    public class Run {
        public static void main(String[] args) {
            String file = FileExporterFactory.getInstance(FileExporterFactory.FileType.EXCEL)
                    .export("Test EXCEL file content");
            System.out.println(file);
        }
    }
* Son olarak main metdoumuzun içini ve kodun nasıl çalıştığını inceleyelim.

* **getInstance** metodumuz static bir metod olduğu için class adı ile birlikte metodumuz çağırdık ve parametre olarak hagi dosya türünü istediğimizi verdik.

* Ardından **getInstance** metodumuz bize arka planda bir **ExcelExporter** instance'ı yarattı. Bizde bu instance'ın **export** metodunu istediğimiz data parametresi ile çalıştırdık.

* **ExcelExporter** içerisindeki **export** metodu çalışıp bize çıktısını döndürdü ve bunu bir değişkene alıp ekranda gösterdik.

* Bu patterni kullanım amacına uygun olarak **ExcelExporter** yada **PdfExporter** class'larının instance'larını yaratma işini arkaplanda kullanıcıdan habersiz olarak hallettik. Kullanıcı sadece istediği dosya türünü seçerek işlemini halletmiş oldu.

### Kaynaklar

- https://www.youtube.com/watch?v=xy7wiUjCps4&list=PLd0jsEi3hUAe6qL7iDfDzr8n8DvigHXmv&index=2&ab_channel=HaydiKodlayalim

- https://blog.burakkutbay.com/design-pattern-factory-pattern-nedir.html/