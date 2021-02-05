# Template Method Pattern

>_**Template Method Pattern, Behavioural Design Pattern grubunda yer alır.**_
>
>Template Method Pattern, bir işlem için gerekli adımları soyut olarak tanımlar ve bir şablon metod ile algoritmanın nasıl çalışacağını belirler.

* **Strategy Design Pattern‘i davranışın tamamen değiştiği durumlarda, Template Method Design Pattern’i ise davranışın bir kısmı değiştiği durumlarda kullanılır.**

&NewLine;
* Örneğin, bir ev inşa etmek istiyoruz. Ev inşa etmek için şu adımlar gereklidir: bina temel atılması, bina sütunları, bina duvarları ve pencereler. Burada dikkat edilecek olan husus, adımların sırayla yapılmasının zorunlu olmasıdır. Pencereler takıldıktan sonra temel atılamaz, önce temel atılır sonra bina sütunları yapılır, daha sonra duvarlar yapılır en son ise pencereler yapılır. Template metod tasarımı ile bu adımların sırasıyla yapılması zorunlu hale getirilmiştir.

&NewLine;
Daha somut bir örnek ile açıklayalım.

* Futbol ve kriket sporları için oyunun başlama ve bitme süreçlerini düşünelim ve bunu template şablonu ile yapmaya çalışalım.

* Amacımız oyunun initilize, start, ve end metodlarının sırasıyla çalışmasını sağlamaktır.

1. Abstract class'ımızı oluşturarak başlayalım.

    &NewLine;
    Game
    ```
    public abstract class Game {
            abstract void initialize();
            abstract void startPlay();
            abstract void endPlay();

            //template method
            public final void play() {

                //initialize the game
                initialize();

                //start game
                startPlay();

                //end game
                endPlay();
            }
        }
    ```

* Burada dikkat etmemiz gereken kısım **play()** metodumuzdur.

* Bu metod yukarıda imzaları yazılmış olan 3 tane metodun sırayla çağrılmasını sağlar.

2. Abstract class'ımız extend eden class'larımızı oluşturalım.

    &NewLine;
    Cricket
    
    ```
    public class Cricket extends Game {

            @Override
            void endPlay() {
                System.out.println("Cricket Game Finished!");
            }

            @Override
            void initialize() {
                System.out.println("Cricket Game Initialized! Start playing.");
            }

            @Override
            void startPlay() {
                System.out.println("Cricket Game Started. Enjoy the game!");
            }
        }
    ```
 	 Football
    ```
    public class Football extends Game {

            @Override
            void endPlay() {
                System.out.println("Football Game Finished!");
            }

            @Override
            void initialize() {
                System.out.println("Football Game Initialized! Start playing.");
            }

            @Override
            void startPlay() {
                System.out.println("Football Game Started. Enjoy the game!");
            }
        }
    ```

3. Son olarak main metodumuzu yazalım.

    &NewLine;
    TemplatePatternDemo
    ```
    public class TemplatePatternDemo {
            public static void main(String[] args) {

                Game game = new Cricket();
                game.play();
                System.out.println();
                game = new Football();
                game.play();
            }
    }
    ```
    


* Main metodumuz oyunun instance'ını oluşturur ve **play()** metodu çağırılır.

* **play()** metodu abstract sınıfımızdan kalıtım yoluyla sahip olduğumuz bir metod olduğu için oyun sınıfındaki metodlarımız abstract class'ta belirtilen sıra ile çalıştırılır.

* Böylelikle Template Method Pattern'den tanımladığımız bir şablon method ile çalışma şeklini uygulamış oluruz.

### Kaynaklar

- https://www.codesenior.com/tutorial/Template-Metod-Tasarim-Deseni

- https://medium.com/@yasinmemic/template-design-pattern-nedir-d91ceb271b80

- https://www.tutorialspoint.com/design_pattern/template_pattern.htm

- https://bidb.itu.edu.tr/seyir-defteri/blog/2013/09/08/%C5%9Fablon-metot-kal%C4%B1b%C4%B1-(template-method-pattern)
