# Strategy Pattern
> _**Strategy Pattern, Behavioural Design Pattern grubunda yer alır.**_
>
> Bir durum gerçekleşeceği zaman birden fazla seçeneğimiz varsa istenilen veya gerçekleşmesi beklenen seçime(stratejiye) kolaylıkla ulaşmamızı sağlayan bir strateji sınıfına ihtiyaç duyulur. Seçeneklerimiz arttıkça kolaylıkla ekleme yapabilir veya durumlar arası geçişi kod fazlalığı olmadan gerçekleştirebiliriz. Ayrıca Stratejilerden birinde değişiklik yapmak istediğimizde direk onun üzerinde kolaylıkla yapabiliriz.

&NewLine;
* Sık kullanılan bir örnekte havalimanına giderken birçok seçeneğimiz vardır.Bu ulaşım biçimleri kendi arabamızla, otobüsle, taksi gibi..

* Her aracın ulaşım zamanı ve maaliyeti farklı olacaktır. HavaalaniUlasim sınıfında ücret ve zaman metodlarını tanımladığımızda tercih edilen stratejiye göre yani otobüs seçilmiş ise otobüsün masraf ve ulaşım zamanını getirecektir. Bu sayede sınıfımız if-else kod kalabalığından arınmış da olacaktır. Daha sonra araçlardan birinin ulaşım masrafında değişiklik olduğunda bunu düzenlemekte kolay olacaktır.

&NewLine;
* Daha somut bir örnek ile açıklayalım.

* Verdiğimiz 2 sayıyı toplama, çıkarma veya çarpma işlemine sokmak istiyoruz,

* Burada dikkat etmemiz gereken 2 sayıyı farklı şekilde işlemlere sokabilecek olmamız. Yani birden farklı stratejimiz olabilir.Bu örneği strategy pattern ile yapmaya çalışalım.

&NewLine;
1. Öncelikle bir Strategy interface'i oluşturmakla işe başlayalım.

_Strategy_

      public interface Strategy {
        public int doOperation(int num1, int num2);
      }

* Bu interface'i implement eden tüm classlarımızda **doOperation** adında bir metod olmasını istiyoruz.

&NewLine;
2. Interface'imizi implement eden birden fazla class oluşturalım.

_OperationAdd_

      public class OperationAdd implements Strategy{
        @Override
        public int doOperation(int num1, int num2) {
             return num1 + num2;
        }
      }

_OperationSubstract_

    public class OperationSubstract implements Strategy{
      @Override
      public int doOperation(int num1, int num2) {
          return num1 - num2;
      }
    }

_OperationMultiply_

    public class OperationMultiply implements Strategy{
      @Override
      public int doOperation(int num1, int num2) {
          return num1 * num2;
      }
    }

&NewLine;
3. Ardından **Context** sınıfımızı oluşturuyoruz.


_Context_

    public class Context {
      private Strategy strategy;

      public Context(Strategy strategy){
          this.strategy = strategy;
      }

      public int executeStrategy(int num1, int num2){
          return strategy.doOperation(num1, num2);
      }
    }

* Bu sınıfta strategy'imizi seçip o strategy'nin **doOperation** metodunu çağırıyoruz.

&NewLine;
4. Son olarak main metodunda **Context** oluşturuken **Strategy** seçip kodumuzu çalıştırıyoruz.

_StrategyPatternDemo_

    public class StrategyPatternDemo {
      public static void main(String[] args) {
          Context context = new Context(new OperationAdd());
          System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

          context = new Context(new OperationSubstract());
          System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

          context = new Context(new OperationMultiply());
          System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
      }
    }

* Context'i oluştururken stratejimizi seçip istediğimiz class'a ait **doOperation** metodunun çalışmasını sağlayabiliyoruz. Böylelikle istediğimiz strateji arasında kolaylıkla seçim veya değişiklik yapabiliyoruz.

## Kaynaklar

- https://kubitokya.wordpress.com/2017/03/26/strategy-tasarim-deseni/

- https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm

- https://www.youtube.com/watch?v=5upBcx8Z7FM&ab_channel=Sad%C4%B1kBahad%C4%B1rMemi%C5%9F