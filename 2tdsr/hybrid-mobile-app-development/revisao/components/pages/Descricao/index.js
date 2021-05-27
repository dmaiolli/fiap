import React from 'react';
import {
  Button,
  Image,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
} from 'react-native';

class Descricao extends React.Component {
  render() {
    return (
      <View style={styles.page}>
        <TouchableOpacity
          onPress={() => {
            if (typeof this.props.onPressFechar === 'function') {
              this.props.onPressFechar;
            }
          }}
          style={styles.fechar}>
          <Text>X</Text>
        </TouchableOpacity>

        <Text style={styles.produtoDescricaoNome}>
          {this.props.produto.nome}
        </Text>

        <Image
          source={{uri: this.props.produto.imagem}}
          style={styles.produtoDescricaoImagem}
        />

        <Text style={styles.produtoDescricao}>
          {this.props.produto.descricao}
        </Text>

        <View style={styles.horizontal}>
          <Text style={styles.produtoDescricaoValor}>
            {this.props.produto.valor}
          </Text>

          <Text style={styles.produtoDescricaoValor}>
            Estoque: {this.props.produto.estoque}
          </Text>
        </View>

        {this.props.produto.estoque <= 0 ? (
          <Button disabled={true} color="#489800" title="Indisponível" />
        ) : (
          <Button color="#489800" title="Comprar" />
        )}
      </View>
    );
  }
}

export default Descricao;

const styles = StyleSheet.create({
  produtoDescricaoNome: {
    fontSize: 28,
    fontWeight: 'bold',
  },
  produtoDescricaoImagem: {
    height: 200,
    marginVertical: 8,
  },
  produtoDescricaoValor: {
    fontSize: 18,
    fontWeight: 'bold',
    marginVertical: 8,
  },
  horizontal: {
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  fechar: {
    alignSelf: 'flex-end',
    padding: 8,
  },
});
