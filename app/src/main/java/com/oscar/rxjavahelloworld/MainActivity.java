package com.oscar.rxjavahelloworld;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.oscar.rxjavahelloworld.API.ControllerAPI;
import io.reactivex.Observable;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText txtConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtConsulta=(EditText)findViewById(R.id.txtConsulta);
        ControllerAPI ctrl=new ControllerAPI();
        RxTextView.textChanges(txtConsulta).subscribe(text->{
            ctrl.buscar(text.toString()).subscribe(newResponse -> {
                try {
                    if (newResponse.getResult() != null) {
                        Observable.fromIterable(newResponse.getResult()).subscribe(result -> {
                            Log.i(TAG, "onCreate:" + result.getDisplayName());
                        });
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        });

    }


    /*

        private Subscription subscription;


       Observable.just(1, 2, 3, 4, 5, 6).filter(integer -> integer % 2 == 0).subscribe(getObserver());


        //producer
        Observable<String> observable = Observable.just("how", "to", "do", "in", "java");

        //consumer
        Consumer<? super String> consumer = System.out::println;

        //Attaching producer to consumer
        observable.subscribe(consumer);





        Observable<String> observer = Observable.just("Hello"); // provides datea
        observer.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        ArrayList<String>items=new ArrayList<>();
        items.add("Prueba 1");
        items.add("Prueba 2");
        Observable.fromIterable(items).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });



        final Observable<Integer> serverDownloadObservable = Observable.create((ObservableOnSubscribe<Integer>) e -> {
            SystemClock.sleep(1000); // simulate delay
            e.onNext(5);
            e.onComplete();
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());

        serverDownloadObservable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer value) {
                Toast.makeText(MainActivity.this,value.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
    private Observer<Integer> getObserver() {
        return new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, " onNext ");
                Log.d(TAG, " value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, " onComplete");
            }
        };
    }
    * */
}
