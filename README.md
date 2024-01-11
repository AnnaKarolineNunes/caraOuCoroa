# App Cara ou Coroa

## Descrição
Neste projeto, ao criar o app Cara ou Coroa, foi possivel praticar a passagem de dados entre activities bem como a criação de layouts responsivos com arquivos XML. 

## Processo de desenvolvimento

- Passo 1 : Após criar o projeto no android studio, iniciamos a construção do layout da tela principal
- Passo 2 : No MainActivity.class devemos criar os atributos referentes aos componentes de interface criados
    ```
    private ImageView imageCaraOuCoroa;
    private ImageButton imageButton;
    
- Passo 3 Utilizar o findViewById dentro do método OnCreate() para relacionar com os componentes de interface
    ```
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCaraOuCoroa = findViewById(R.id.imageCaraOuCoroa);
        imageButton = findViewById(R.id.imageButtonJogar);

- Passo 4 Criar a segunda Activity ( ResultadoActivity.class) para mostrar a 2a tela com o resultado do jogo. Nessa tela, teremos uma imagem posicionada ao centro junto com um botão de voltar ( ImageButton)
- Passo 5 No código do ResultadoActivity.class, iremos criar os atributos e passsar o método findViewById
   ```
   public class ResultadoActivity extends AppCompatActivity {

    private ImageView imageResultado;
    private ImageButton buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imageResultado = findViewById(R.id.imageResultado);
        buttonVoltar = findViewById(R.id.buttonVoltar);
        
    }
}

- Passo 6  Agora com a 2a tela devidamente criada, devemos voltar na MainActivity.class e criar o evento de click dentro do método OnCreate()
    ```
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCaraOuCoroa = findViewById(R.id.imageCaraOuCoroa);
        imageButton = findViewById(R.id.imageButtonJogar);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
  
            }
        });
    }
    
- Passo 7 Com o método criado, vamos passar uma intenção ( intent) a fim de direcionar para outra activity
    ```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCaraOuCoroa = findViewById(R.id.imageCaraOuCoroa);
        imageButton = findViewById(R.id.imageButtonJogar);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);

            }
        });
    }
   
- Passo 8 Passar os dados para a próxima tela com o intent.putExtra() e startActivity()
    ```
    imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);


                // Passar dados para a proxima tela
                int numero = new Random().nextInt(2);

                intent.putExtra("numero", numero);
                startActivity(intent);
            }
        });
    
- Passo 9 Com os dados passados, vamos recuperá-los no ResultadoActivity.class dentro do método onCreate() utilizando o recurso Bundle , getIntent().getExtras()
    ```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imageResultado = findViewById(R.id.imageResultado);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        // recuperar dados
        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("numero");
    
    }
    
- Passo 9 Com os dados recuperados vamos verificar se é cara ou coroa com if else. Logo após iremos criar um evento de click com o buttonVoltar para finalizar essa activity, voltar para a tela principal e inicializar o jogo novamente.
    ```
    // verificar se é cara ou coroa

        if (numero == 0 ){ // cara
            imageResultado.setImageResource(R.drawable.moeda_cara);
        }else { // coroa
            imageResultado.setImageResource(R.drawable.moeda_coroa);
        }

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    
## Capturas de Tela

- Resultado final :
  
![image](https://github.com/AnnaKarolineNunes/caraOuCoroa/assets/101477642/057226d7-5429-468e-8270-9b1daba6e933)
![image](https://github.com/AnnaKarolineNunes/caraOuCoroa/assets/101477642/8a1d3470-cbed-4911-96db-cb42096f8d9b)
    






    
