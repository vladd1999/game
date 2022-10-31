import { FC } from "react";
import { useNavigate } from "react-router-dom";
import { Container, HomeContainer, Wrapper, Title } from "../styles";
import Button from "../components/button";
import Input from "../components/input";

const CreateGame : FC = () => {
    const navigate = useNavigate();
    const routeChange = () =>{ 
        let path = `/`; 
        navigate(path);
      }
    return(
    <Container>
      <Title>Title</Title>
      <HomeContainer>
          <Button str="Go Back"/>
          <Wrapper>
            <Input placeholder="Select the room password"/>
            <Input placeholder="Max players number"/>
          </Wrapper>
          <Wrapper>

          <Button str="Create game"/>
          </Wrapper>
      </HomeContainer>
    </Container>
);
}
export default CreateGame;