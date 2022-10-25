import { FC } from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';
import CreateGame from './components/creategame';

import Home from './components/home';
const App:FC = ()=> {
  return (
   <Routes>
    <Route path="/" element={<Home/>}/>
    <Route path="/create" element={<CreateGame/>}/>
    <Route path="/join" /*element={<JoinGame/>}*//>
   </Routes>
  );
}

export default App;
