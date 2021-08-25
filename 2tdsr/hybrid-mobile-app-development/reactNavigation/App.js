import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import Login from './src/components/Login';
import Home from './src/components/Home';

const Stack = createNativeStackNavigator();


const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{
          headerTintColor: '#000'
        }}>

        <Stack.Screen
          name="login"
          component={Login}
          options={{
            title: 'Faça seu login',
            headerStyle: {
              backgroundColor: '#4169e1'
            },
            headerTintColor: '#FFF'
          }} />
        <Stack.Screen
          name="home"
          options={{
            title: 'Home'
          }}
          component={Home} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;