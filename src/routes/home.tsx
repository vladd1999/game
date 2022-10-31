import { FC } from "react";
import { Container, HomeButtons, HomeContainer, SetNameWrapper, Title } from "../styles";
import "../style.scss";
import Button from "../components/button";
import Input from "../components/input";

const Home: FC = () => {
  return (
    <Container>
      <Title>Title</Title>
      <HomeContainer>
        <SetNameWrapper>
         <Input placeholder="text"/>
        </SetNameWrapper>
        <HomeButtons>
          <Button str="Create"/>
          <Button str="Join"/> 
        </HomeButtons>
      </HomeContainer>
    </Container>
  )
} 

export default Home;

