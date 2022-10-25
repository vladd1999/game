import { FC } from "react";
import { useNavigate } from "react-router-dom";
import { Container, CreateButton, HomeContainer, Wrapper, Title } from "../styles";

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
          <button onClick={routeChange}>Go Back</button>
          <Wrapper>
            <input placeholder="Select the room password"/>
            <input placeholder="Max players number"/>
          <CreateButton>Create</CreateButton>
          </Wrapper>
          
        
      </HomeContainer>
    </Container>
);
}
export default CreateGame;