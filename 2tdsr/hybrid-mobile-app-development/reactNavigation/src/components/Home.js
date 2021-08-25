import React from 'react';
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native';


const Home = (props) => {
  const { nome } = props.route.params || '';
  return (
    <View style={styles.container}>
      <Text style={styles.text}>Bem-vindo {nome}!!! =)</Text>

      <TouchableOpacity style={styles.button} onPress={() => {
        props.navigation.goBack();
      }}>
        <Text style={styles.buttonText}>Logout</Text>
      </TouchableOpacity>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#FFF',
    flex: 1,
    padding: 20,
    alignItems: 'center'
  },
  button: {
    width: 370,
    height: 50,
    backgroundColor: "#4169e1",
    alignItems: "center",
    justifyContent: "center",
  },
  buttonText: {
    color: "#FFF",
    fontSize: 17
  },
  text: {
    color: '#000',
    fontSize: 20,
    marginBottom: 15
  },
})

export default Home;