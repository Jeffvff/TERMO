# 🎨 Códigos de Cores ANSI em Java

Utilize os códigos ANSI para exibir textos coloridos no terminal usando Java.

## 🌈 Cores disponíveis

**🔴 Vermelho**
```java
"\u001B[91m" + "TEXTO" + "\u001B[0m"
```

**🟡 Amarelo**
```java
"\u001B[33m" + "TEXTO" + "\u001B[0m"
```

**🟢 Verde**
```java
"\u001B[32m" + "TEXTO" + "\u001B[0m"
```

## 📖 Explicação dos códigos

| Código | Função |
|---|---|
| `\u001B[91m` | Ativa a cor vermelha clara |
| `\u001B[33m` | Ativa a cor amarela |
| `\u001B[32m` | Ativa a cor verde |
| `\u001B[0m` | Restaura a formatação padrão do terminal |

### ⚠️ Importante

O código `\u001B[0m` é utilizado para **restaurar a formatação padrão do terminal**.

Sempre que quiser que o texto seguinte volte à cor normal, utilize esse código.

## 💻 Exemplo de uso

```java
public class Main {
    public static void main(String[] args) {

        System.out.println("\u001B[91m" + "ERRO" + "\u001B[0m");

        System.out.println("\u001B[33m" + "AVISO" + "\u001B[0m");

        System.out.println("\u001B[32m" + "SUCESSO" + "\u001B[0m");
    }
}
```