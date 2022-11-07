import { FC } from "react";

import RoomList from "../components/roomlist";


import { Container,Wrapper } from "../styles";

const JoinGame: FC = () => {
    return (

        <Container>
            
           <Wrapper>
            <RoomList/>
          </Wrapper>
          
        </Container>
    )
}
export default JoinGame;