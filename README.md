

### Explicação do Código

O código implementa um conversor de unidades em Java usando a biblioteca Swing para a interface gráfica. O programa permite ao usuário converter diferentes unidades de medida, como metros, quilômetros, centímetros, decímetros, polegadas, Celsius e Fahrenheit. Abaixo está uma descrição detalhada de cada parte do código:

1. **Classe `ConversorUnidadesFrame`**:
   - **Extensão de `JFrame`**: A classe herda de `JFrame`, tornando-a uma janela da interface gráfica.
   - **Atributos**:
     - `valorInput`: Um campo de texto para entrada do valor a ser convertido.
     - `unidadeOrigem`: Um combo box para selecionar a unidade de origem.
     - `unidadeDestino`: Um combo box para selecionar a unidade de destino.
     - `resultado`: Um rótulo que exibe o resultado da conversão.

   - **Construtor `ConversorUnidadesFrame`**:
     ```java
     public ConversorUnidadesFrame() {
         setTitle("Conversor de Unidades");
         ...
         criarComponentes();
     }
     ```
     Este construtor inicializa a janela com título, tamanho e comportamento padrão, e organiza os componentes usando `GridBagLayout`.

   - **Método `addComponent`**:
     ```java
     private void addComponent(Component component, GridBagConstraints gbc, int gridx, int gridy, int gridwidth, int gridheight) {
         gbc.gridx = gridx;
         gbc.gridy = gridy;
         gbc.gridwidth = gridwidth;
         gbc.gridheight = gridheight;
         add(component, gbc);
     }
     ```
     Um método auxiliar para adicionar componentes à interface com a configuração apropriada de `GridBagConstraints`.

   - **Método `converter`**:
     ```java
     private void converter() {
         try {
             double valor = Double.parseDouble(valorInput.getText());
             ...
             resultado.setText("Resultado: " + resultadoValor);
         } catch (NumberFormatException e) {
             resultado.setText("Por favor, insira um número válido.");
         }
     }
     ```
     Este método captura a entrada do usuário, realiza a conversão de unidades e atualiza o rótulo de resultado. Caso a entrada não seja válida, exibe uma mensagem de erro.

2. **Métodos de Conversão**:
   - O código possui métodos separados para converter entre diferentes unidades de comprimento e temperatura. Cada método recebe um valor e a unidade de destino e retorna o valor convertido. Por exemplo:
     ```java
     private double converterMetros(double valor, String destino) {
         switch (destino) {
             case "Kilômetros":
                 return valor / 1000;
             ...
             default:
                 return valor; // Se for a mesma unidade
         }
     }
     ```
   - Métodos semelhantes são implementados para `Kilometros`, `Centimetros`, `Decimetros`, `Polegadas`, `Celsius` e `Fahrenheit`.

3. **Método `main`**:
   ```java
   public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
           ConversorUnidadesFrame frame = new ConversorUnidadesFrame();
           frame.setVisible(true);
       });
   }
   ```
   O ponto de entrada do programa que cria uma instância da janela do conversor e a torna visível.

### Modelo de README para GitHub

```markdown
# Conversor de Unidades em Java

Este projeto é uma aplicação de conversão de unidades desenvolvida em Java usando a biblioteca Swing para a interface gráfica. O programa permite ao usuário converter valores entre diferentes unidades de medida, incluindo:

- Comprimento: Polegadas, Decímetros, Centímetros, Metros, Kilômetros
- Temperatura: Celsius, Fahrenheit

## Funcionalidades

- Interface gráfica amigável.
- Conversão entre várias unidades de comprimento e temperatura.
- Exibição do resultado da conversão em tempo real.
- Tratamento de erros para entradas inválidas.

## Como Executar

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
   ```

2. **Compile e Execute o Programa**:
   Navegue até o diretório do repositório e compile o programa:
   ```bash
   javac -d . ConversorUnidadesFrame.java
   ```
   Depois, execute o programa:
   ```bash
   java ConversorUnidades.ConversorUnidadesFrame
   ```

## Estrutura do Código

O código é organizado em uma única classe principal:

- **ConversorUnidadesFrame**: Gerencia a interface do usuário e a lógica de conversão.

## Exemplo de Uso

Ao iniciar o programa, o usuário verá uma interface para inserir um valor, selecionar unidades de origem e destino, e um botão para converter:

```
Valor: [       ]
Unidade de Origem: [Polegadas]
Unidade de Destino: [Metros]
[Converter]
Resultado: 
```

Após inserir um valor e clicar em "Converter", o resultado da conversão será exibido abaixo.

## Dependências

- Java 8 ou superior.
- Biblioteca Swing (inclusa na JDK).

```

---

Sinta-se à vontade para personalizar o README de acordo com suas necessidades!
