import pandas as pd
import os

# Defina o caminho absoluto para o arquivo CSV
caminho_arquivo = r'C:\Users\Bel_Lorran\desktop\CadastroTabagismo\pessoas.csv'

# Verifique se o arquivo existe antes de tentar lê-lo
if os.path.exists(caminho_arquivo):
    df = pd.read_csv(caminho_arquivo)

    # Exibir o DataFrame
    print("Dados carregados do CSV:")
    print(df)

    # Exemplo de análise de dados
    print("\nNúmero de pessoas cadastradas:", len(df))
    print("Média de idade:", df['Idade'].mean())
    print("Percentual de fumantes:")
    print(df['Fuma'].value_counts(normalize=True) * 100)
else:
    print("Arquivo CSV não encontrado no caminho especificado.")