import { FC } from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';
import CreateGame from './routes/creategame';

import Home from './routes/home';
import JoinGame from './routes/joingame';
import Lobby from './routes/lobby';
const App:FC = ()=> {
  return (
   <Routes>
    <Route path="/" element={<Home/>}/>
    <Route path="/create" element={<CreateGame/>}/>
    <Route path="/join" element={<JoinGame/>}/>
    <Route path="/lobby" element={<Lobby/>}/>
   </Routes>
  );
}

export default App;
