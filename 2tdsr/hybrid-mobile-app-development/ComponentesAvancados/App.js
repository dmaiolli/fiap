import React from 'react';
import {
  ActivityIndicator,
  Image,
  SafeAreaView,
  KeyboardAvoidingView,
  TextInput,
  StyleSheet,
  ScrollView,
  Text,
  View,
  FlatList,
  StatusBar,
} from 'react-native';

const paises = [
  {
    id: 1,
    nome: 'Argentina',
    bandeira:
      'https://cdn.pixabay.com/photo/2020/06/28/22/09/argentina-flag-5350831_960_720.jpg',
    capital: 'Buenos aires',
  },
  {
    id: 2,
    nome: 'Estados Unidos',
    bandeira:
      'https://cdn.pixabay.com/photo/2015/07/10/17/21/american-839775__340.jpg',
    capital: 'Washington',
  },
  {
    id: 3,
    nome: 'Japão',
    bandeira:
      'https://cdn.pixabay.com/photo/2013/07/13/14/15/japan-162328__340.png',
    capital: 'Tókyo',
  },
  {
    id: 4,
    nome: 'Itália',
    bandeira:
      'https://cdn.pixabay.com/photo/2013/07/13/14/15/italy-162326__340.png',
    capital: 'Petesburg',
  },
];

export default class App extends React.Component {
  render() {
    return (
      <SafeAreaView>
        <StatusBar backgroundColor="#054" />

        <ScrollView>
          <ActivityIndicator color="#F00" size={15} />

          <KeyboardAvoidingView style={{flex: 1}}>
            <View style={{flex: 1, justifyContent: 'center', padding: 16}}>
              <FlatList
                data={paises}
                keyExtractor={item => item.id.toString()}
                renderItem={({item}) => (
                  <View style={styles.container}>
                    <Image
                      source={{uri: item.bandeira}}
                      style={styles.bandeira}
                    />

                    <View>
                      <Text style={styles.title}>{item.nome}</Text>
                      <Text style={styles.capital}>{item.capital}</Text>
                    </View>
                  </View>
                )}
              />

              <TextInput
                style={{borderWidth: 1, marginTop: 8}}
                placeholder="Digite"
              />
            </View>
          </KeyboardAvoidingView>
        </ScrollView>
      </SafeAreaView>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    marginBottom: 16,
  },
  bandeira: {
    width: 100,
    height: 50,
    marginRight: 8,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
  },
  capital: {
    fontSize: 12,
    color: '#F48',
  },
});
