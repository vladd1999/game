import styled from 'styled-components';



export const Container = styled.div`
display: grid;
justify-content : center;
`;

export const HomeContainer = styled.div`
height: 40vh; // 40% view height
width: 40vw;  // 40% view width
margin-top: 2 vh;
border: 0.3vh solid white;
padding: 3vh;
`;

export const HomeButtons = styled.div`
  margin-top: 12vh;
  display : flex;
  justify-content : space-evenly; 
`

export const SetNameWrapper = styled.div`
display:flex;
justify-content: center;
align-content: center;
margin-top: 7vh;
`

export const Title = styled.h1`
margin-top:12vh;
 justify-self: center;
 color:white;
 font-size: 4vh;
`
export const Wrapper = styled.div`
display:grid;
justify-content: center;
align-items: center;
margin-top:3vh;   
`
export const ProfileImg = styled.img`
  border-radius: 200px;
  max-width: 8vh;
  max-height: 8vh;
  opacity:0.8;
  align-self: center;
  `
export const CardsContainer = styled.div`
   display: flex;
   justify-content : center;
   `

export const TableContainer = styled.div`
background-image: url("https://static.vecteezy.com/system/resources/previews/006/325/236/large_2x/poker-table-green-cloth-on-dark-background-illustration-free-vector.jpg");
background-size:100%;
background-repeat: no-repeat;
width:98vw;
height: 98vh;
border: 0.3vh solid white;
position: relative;
`

export const PlayerContainer = styled.div`
 position: absolute;
 display:table; 
 align-content:center;
 justify-content:center; 
 text-align: center;
 top:38vh;
 right:21vw;
 width:18vw;
 height: 20vh;
 border: 0.3vh solid white;
 color:gray;
 opacity:0.8;
 border-radius:50px;
`