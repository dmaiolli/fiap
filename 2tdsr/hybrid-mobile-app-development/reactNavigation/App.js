import React from 'react';
import { Button, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
const Stack = createNativeStackNavigator();

import { createBottomTabNavigator} from '@react-navigation/bottom-tabs';
const Tab = createBottomTabNavigator();

import { createDrawerNavigator } from '@react-navigation/drawer';
const Drawer = createDrawerNavigator();

const Home = (props) => {
  return (
    <View>
      <Text>Exemplo de navegação</Text>
      <Button onPress={() => {
        props.navigation.navigate('otherActivity', {
          nome: 'Denys Maiolli'
        });
      }} title="Abrir outra tela" />
    </View>
  )
}

const OtherActivity = (props) => {
  const { nome } = props.route.params || '';

  return (
    <View>
      <Text>Outra tela</Text>
      <Text>Olá {nome}</Text>
      <Button onPress={() => {
        props.navigation.goBack();
      }} title="Fechar" />
    </View>
  )
}

const App = () => {
  return (
    <NavigationContainer>
      <Drawer.Navigator>
         <Drawer.Screen name="home" component={Home}/>
         <Drawer.Screen name="otherActivity" component={OtherActivity}/>
      </Drawer.Navigator>

  {/*
    <Tab.Navigator>
    <Tab.Screen name="home" component={Home}/>
    <Tab.Screen name="otherActivity" component={OtherActivity} />
    </Tab.Navigator>
  */}

 {/*
     <Stack.Navigator
     screenOptions={{
       headerTintColor: '#485'
      }}>
        <Stack.Screen 
          name="home" 
          options={{
            title: 'Tela 1'
          }} 
          component={Home} />
        <Stack.Screen 
          name="otherActivity" 
          component={OtherActivity}
          options={{
            title: 'Outra tela',
            headerStyle: {
              backgroundColor: '#f00'
            },
            headerTintColor: '#FFF'
          }} />
      </Stack.Navigator>
        */}
    </NavigationContainer>
  );
}

export default App;