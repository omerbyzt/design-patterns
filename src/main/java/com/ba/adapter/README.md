# Adapter Design Pattern

>_**Adapter Design Pattern, Structural Design Pattern grubunda yer alır.**_
>
>Bu tasarım deseni, birbiriyle ilişkili olmayan interface'lerin birlikte çalışmasını sağlar. Bu işlemi ise, bir sınıfın interface'ini diğer bir interface'e dönüştürerek yapar.

&NewLine;
* Adapter tasarım deseni ismini gerçek hayattaki adaptörlerden almıştır. Örneğin, telefon şarj cihazı bir adaptördür. 240V'luk gerilimi 5V'a dönüştürür. Mobil şarz cihazı, mobil şarj soketi ile duvar soketi arasında bir adaptör görevi görür.


* Farklı interface'lere sahip sınıfların birbiriyle çalışabilmesini sağlamak amacıyla kullanılır. Örnek vermek gerekirse, bir XML dosyasının Document Object Model interface'ini bir ağaç yapısına dönüştürülmesi için kullanılabilir.

### Faydaları Nelerdir?
1. Birbiriyle ilişkili olmayan interface'lerin birlikte çalışmasını sağlar.
2. Kodların yeniden yazılması engeller.
3. Var olan modül(ler) değiştirilmeden sisteme yeni modüller eklenebilir.

Somut bir örnek ile açıklamaya çalışalım.

1. İlk olarak farklı 2 interface tanımlayalım.
&NewLine;
Duck

    /**
    * Target interface
    */
    public interface Duck {
        public void quack();
        public void fly();
    }
Turkey

    /**
    * Adaptee interface
    */
    public interface Turkey {
        public void gobble();
        public void fly();
    }

* Interface'lerimizden biri **target** diğeri de **adaptee** olmalıdır.
* **Adaptee** dediğimiz interface'imiz **target** interface'e dönüştürülecek olandır.

2. Adaptee sınıfımızın somut sınıfını oluşturalım.
&NewLine;
WildTurkey

    /**
    * Somut Adaptee sinifi
    */
    public class WildTurkey implements Turkey {
        public void gobble() {
            System.out.println("Gobble gobble");
        }

        public void fly() {
            System.out.println("I'm flying a short distance");
        }
    }

3. Şimdi sırada dönüştürme işlemini yapacak olan sınıf yani adapter sınıfını oluşturalım.
&NewLine;
TurkeyAdapter

    /**
    * Adapter sinifi
    */
    public class TurkeyAdapter implements Duck {
        Turkey turkey;

        public TurkeyAdapter(Turkey turkey) {
            this.turkey = turkey;
        }

        public void quack() {
            turkey.gobble();
        }

        public void fly() {
            turkey.fly();
        }
    }

* Burada yaptığımız işlemleri inceleyelim.
  1. İlk olarak adapter sınıfı dikkat edileceği üzere constructor'ında **Turkey** nesnesi ister fakat **Duck interface**'ini implements eder.

  2. Buda aslında amacımızı göstermektedir.

  3. Gelen _Turkey_ nesnesinin **gooble()** ve **fly()** metodları duck interface'inin metodlarının içinde çağırılır. Böylelikle _Turkey_ nesnesinin sahip olduğu metodları _Duck_ nesnesine adapte etmiş oluruz.

4. Son olarak main metodumuzu yazalım.
&NewLine;
DuckTestDrive

    public class DuckTestDrive {
        public static void main(String[] args) {
            WildTurkey turkey = new WildTurkey();
            Duck turkeyAdapter = new TurkeyAdapter(turkey);

            System.out.println("The Turkey says...");
            turkey.gobble();
            turkey.fly();

            System.out.println("\nThe TurkeyAdapter says...");
            testDuck(turkeyAdapter);
        }

        static void testDuck(Duck duck) {
            duck.quack();
            duck.fly();
        }
    }

* Bir tane _Turkey_ nesnesi oluştururuz.

* Ardından bu _Turkey_ nesnesini adapter classa'a veririz ve sonucunda elimizde bir _Duck_ nesnesi olur.

* Oluşan _Duck_ nesnesinin normalde _Turkey_ nesnesinde olmayan **quack()** metodunu kullanabildiğini görmüş oluruz.

* Böylelikle başarılı bir şekilde _Turkey_ nesnesinin _Duck interface_'ine dönüştürülme işlemini tamamlamış oluruz.
### Kaynaklar

- https://www.codesenior.com/tutorial/Adaptor-Adapter-Tasarim-Deseni
