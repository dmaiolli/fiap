import 'react-native-gesture-handler';

import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';

import { SafeAreaView, View, Text } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';

const Stack = createStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="login" component={Login} />
        <Stack.Screen name="home" component={Home} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const Login = () => {
  return (
    <SafeAreaView>
      <View>
        <Text>A</Text>
      </View>
    </SafeAreaView>
  )
}

const Home = () => {
  return (
    <SafeAreaView>
      <View>
        <Text>A</Text>
      </View>
    </SafeAreaView>
  )
}


export default App;