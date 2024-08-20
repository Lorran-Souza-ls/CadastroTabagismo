import pandas as pd

# Ler o arquivo CSV gerado pelo Java
df = pd.read_csv('pessoas.csv')

# Exibir o DataFrame
print("Dados carregados do CSV:")
print(df)

# Exemplo de análise de dados
print("\nNúmero de pessoas cadastradas:", len(df))
print("Média de idade:", df['Idade'].mean())
print("Percentual de fumantes:")
print(df['Fuma'].value_counts(normalize=True) * 100)
