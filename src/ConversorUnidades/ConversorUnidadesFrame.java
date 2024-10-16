package ConversorUnidades;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ConversorUnidadesFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField valorInput;
    private JComboBox<String> unidadeOrigem;
    private JComboBox<String> unidadeDestino;
    private JLabel resultado;

    public ConversorUnidadesFrame() {
        setTitle("Conversor de Unidades");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento

        // Criar componentes
        JLabel labelValor = new JLabel("Valor:");
        labelValor.setFont(new Font("Arial", Font.BOLD, 14));
        addComponent(labelValor, gbc, 0, 0, 1, 1);

        valorInput = new JTextField();
        valorInput.setFont(new Font("Arial", Font.PLAIN, 14));
        addComponent(valorInput, gbc, 1, 0, 2, 1);

        String[] unidades = {"Polegadas", "Decímetros", "Centímetros", "Metros", "Kilômetros", "Celsius", "Fahrenheit"};
        unidadeOrigem = new JComboBox<>(unidades);
        addComponent(new JLabel("Unidade de Origem:"), gbc, 0, 1, 1, 1);
        addComponent(unidadeOrigem, gbc, 1, 1, 2, 1);

        unidadeDestino = new JComboBox<>(unidades);
        addComponent(new JLabel("Unidade de Destino:"), gbc, 0, 2, 1, 1);
        addComponent(unidadeDestino, gbc, 1, 2, 2, 1);

        JButton converterButton = new JButton("Converter");
        converterButton.setFont(new Font("Arial", Font.BOLD, 14));
        converterButton.setBackground(new Color(0x007BFF));
        converterButton.setForeground(Color.WHITE);
        converterButton.setBorderPainted(false);
        converterButton.setFocusPainted(false);
        converterButton.setOpaque(true);
        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converter();
            }
        });
        addComponent(converterButton, gbc, 0, 3, 3, 1);

        resultado = new JLabel("Resultado: ");
        resultado.setFont(new Font("Arial", Font.PLAIN, 14));
        resultado.setForeground(Color.BLUE);
        addComponent(resultado, gbc, 0, 4, 3, 1);
    }

    private void addComponent(Component component, GridBagConstraints gbc, int gridx, int gridy, int gridwidth, int gridheight) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        add(component, gbc);
    }

    private void converter() {
        try {
            double valor = Double.parseDouble(valorInput.getText());
            String origem = (String) unidadeOrigem.getSelectedItem();
            String destino = (String) unidadeDestino.getSelectedItem();
            double resultadoValor = 0;

            // Conversão entre unidades
            if (origem.equals("Metros")) {
                resultadoValor = converterMetros(valor, destino);
            } else if (origem.equals("Kilômetros")) {
                resultadoValor = converterKilometros(valor, destino);
            } else if (origem.equals("Centímetros")) {
                resultadoValor = converterCentimetros(valor, destino);
            } else if (origem.equals("Decímetros")) {
                resultadoValor = converterDecimetros(valor, destino);
            } else if (origem.equals("Polegadas")) {
                resultadoValor = converterPolegadas(valor, destino);
            } else if (origem.equals("Celsius")) {
                resultadoValor = converterCelsius(valor, destino);
            } else if (origem.equals("Fahrenheit")) {
                resultadoValor = converterFahrenheit(valor, destino);
            }

            resultado.setText("Resultado: " + resultadoValor);
        } catch (NumberFormatException e) {
            resultado.setText("Por favor, insira um número válido.");
        }
    }

    // Métodos de conversão separados
    private double converterMetros(double valor, String destino) {
        switch (destino) {
            case "Kilômetros":
                return valor / 1000;
            case "Centímetros":
                return valor * 100;
            case "Decímetros":
                return valor * 10;
            case "Polegadas":
                return valor * 39.3701;
            default:
                return valor; // Se for a mesma unidade
        }
    }

    private double converterKilometros(double valor, String destino) {
        switch (destino) {
            case "Metros":
                return valor * 1000;
            case "Centímetros":
                return valor * 100000;
            case "Decímetros":
                return valor * 10000;
            case "Polegadas":
                return valor * 39370.1;
            default:
                return valor; // Se for a mesma unidade
        }
    }

    private double converterCentimetros(double valor, String destino) {
        switch (destino) {
            case "Metros":
                return valor / 100;
            case "Kilômetros":
                return valor / 100000;
            case "Decímetros":
                return valor / 10;
            case "Polegadas":
                return valor / 2.54;
            default:
                return valor; // Se for a mesma unidade
        }
    }

    private double converterDecimetros(double valor, String destino) {
        switch (destino) {
            case "Metros":
                return valor / 10;
            case "Kilômetros":
                return valor / 10000;
            case "Centímetros":
                return valor * 10;
            case "Polegadas":
                return valor * 3.93701;
            default:
                return valor; // Se for a mesma unidade
        }
    }

    private double converterPolegadas(double valor, String destino) {
        switch (destino) {
            case "Metros":
                return valor / 39.3701;
            case "Kilômetros":
                return valor / 39370.1;
            case "Centímetros":
                return valor * 2.54;
            case "Decímetros":
                return valor * 10 / 39.3701;
            default:
                return valor; // Se for a mesma unidade
        }
    }

    private double converterCelsius(double valor, String destino) {
        switch (destino) {
            case "Fahrenheit":
                return (valor * 9 / 5) + 32;
            default:
                return valor; // Se for a mesma unidade
        }
    }

    private double converterFahrenheit(double valor, String destino) {
        switch (destino) {
            case "Celsius":
                return (valor - 32) * 5 / 9;
            default:
                return valor; // Se for a mesma unidade
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversorUnidadesFrame frame = new ConversorUnidadesFrame();
            frame.setVisible(true);
        });
    }
}
