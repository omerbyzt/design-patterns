# Observer Design Pattern
> _**Observer Design Pattern, Behavioural Design Pattern grubunda yer alır.**_
>
> Bu tasarım kalıbı, nesneler arasında one-to-many ilişkisi olduğu durumlarda tercih edilen bir kalıptır. Yani bir nesnede olan herhangi bir değişiklik, bu nesneye bağımlı diğer nesneleri de etkiliyorsa bu şablon kullanılır.

&NewLine;

Observer pattern, 3 aktör sınıf kullanır. Bu sınıflar; Subject, Observer ve Client sınıflarıdır. 

1. **Subject**: İçerisinde gözlemci listesini tutar ve bu listeye ekleme yapmayı sağlayan _Attach()_ metotunu barındırır. Ayrıca _Notify()_ metodu ile ilgili gözlemciye bildirim gönderilmesini sağlar. 

2. **Observer**: Bir interface’dir. İçerisinde _update()_ metodu bulunur. Bu sınıftan miras alacak olan gözlemciler de mecburen içlerinde update() metodunu barındırırlar. Alt sınıfların ortak bir interface’den faydalanması amaçlanır.

3. **Client**: Sistemi kullanacak olan istemcidir.


Daha somut bir örnek ile açıklayalım.

* İstemcinin 10'luk tabanda girdiği sayıyı bir değişim olarak algılayıp, 2'lik, 8'lik ve 16'lık taban gözlemcilerine otomatik olarak bildirim gönderen bir sistemi observer design pattern yardımıyla yapalım. Yani sisteme girilen her yeni sayı yeni bir güncelleme gibi algılanacak. Dolayısıyla güncelleme de, bu sınıfı izleyen gözlemcilere bildirim olarak gönderilecek ve sonuç olarak girilen sayının 2–8–16 ‘lık değerleri ekrana yazdırılacak.

1. **Bir Subject sınıfı oluştur.**

    Subject
    ```
    import java.util.ArrayList;
            import java.util.List;

            public class Subject {

                private List<Observer> observers = new ArrayList<Observer>();
                private int state;

                public int getState() {
                    return state;
                }
                public void setState(int state) {
                    this.state = state;
                    notifyAllObservers();
                }

                public void attach(Observer observer){
                    observers.add(observer);
                }

                public void notifyAllObservers(){
                    for (Observer observer : observers) {
                        observer.update();
                    }
                }
            }
    ```

2. **Bir Observer sınıfı oluştur.**

    Observer
    ```
    public abstract class Observer {
            protected Subject subject;
            public abstract void update();
          }

    ```
      
3. **Abstract sınıfımızı kullanacak sınıflarımız oluşturulur.**
 
    BinaryObserver

    ```
    public class BinaryObserver extends Observer{
            public BinaryObserver(Subject subject){
                this.subject = subject;
                this.subject.attach(this);
            }

            @Override
            public void update() {
                System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
            }
        }
    ```
    
    OctalObserver

    ```
    public class OctalObserver extends Observer{

        public OctalObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
        }
    }
    ```
    
      HexaObserver
    ```
    public class HexaObserver extends Observer{
              public HexaObserver(Subject subject){
                  this.subject = subject;
                  this.subject.attach(this);
              }

              @Override
              public void update() {
                  System.out.println("Hex String: " + Integer.toHexString(subject.getState() ).toUpperCase());
              }
          }
    ```
      

4. **Son olarak main metodunda kodumuzu çalıştıralım.**

    ObserverPatternDemo
    ```
    public class ObserverPatternDemo {
          public static void main(String[] args) {

                Subject subject = new Subject();

                new HexaObserver(subject);
                new OctalObserver(subject);
                new BinaryObserver(subject);

                System.out.println("First state change: 15");
                subject.setState(15);
                System.out.println("**********************");

                System.out.println("Second state change: 10");
                subject.setState(10);
            }
     }
    ```

* Öncelikle **Subject** classımızın bir instance'ı oluşturuldu.

* Ardından bu subject nesnesini parametre alan **Observer'larımız** oluşturuldu.

* Oluşan her bir observer constructor'ında subject nesnesinin **attach()** metodunu çalıştırarak kendini observer listesine ekledi.

* Böylelikle subject nesnesinin **setState()** metodu her çağırıldığında observer listesine eklenen her sınıfın **update()** metodu **notifyAllObservers()** tarafından çağrılır ve çalıştırılmış olur.

* Observer listesine yeni hangi class eklenirse bir sonraki değişiklikte oda bu sisteme otomatik dahil edilmiş olur.

### Kaynaklar

- https://medium.com/@yasinmemic/observer-design-pattern-41162726f899
