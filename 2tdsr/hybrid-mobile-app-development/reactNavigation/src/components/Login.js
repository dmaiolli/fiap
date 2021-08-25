import React from 'react';
import { StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';

const Login = (props) => {
  const [user, onChangeUser] = React.useState("");
  const [password, onChangePassword] = React.useState("");

  const validateUser = user === 'fiap' && password === 'fiap';

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Login</Text>

      <Text style={styles.text}>Usuário</Text>
      <TextInput style={styles.input} value={user} onChangeText={onChangeUser} />

      <Text style={styles.text}>Senha</Text>
      <TextInput style={styles.input} secureTextEntry={true} value={password} onChangeText={onChangePassword} />

      <TouchableOpacity value="Login" style={styles.button} onPress={() => {
        if (validateUser) {
          props.navigation.navigate('home', {
            nome: `${user}`
          });
        } else {
          alert('Usuário ou senha inválido')
        }
      }}>
        <Text style={styles.buttonText}>Login</Text>
      </TouchableOpacity>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#FFF',
    flex: 1,
    padding: 15,
  },
  title: {
    fontSize: 25,
    fontWeight: "600",
    textAlign: 'center',
    marginBottom: 10
  },
  text: {
    color: '#000',
    fontSize: 20
  },
  input: {
    width: 370,
    borderRadius: 8,
    borderColor: "#000",
    backgroundColor: '#FFF',
    borderWidth: 1,
    padding: 5,
    marginBottom: 15,
    fontSize: 15,
    marginTop: 5
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
  }
})

export default Login;