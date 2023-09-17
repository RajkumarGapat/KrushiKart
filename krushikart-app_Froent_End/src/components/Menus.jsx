import React from 'react'
import { ListGroup, ListGroupItem } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'

const Menus = () => {
  return (
    <div>
      <ListGroup>
        <LinkContainer to="/">
          <ListGroupItem tag="a" href="#!" action>
            Home
          </ListGroupItem>
        </LinkContainer>

        <LinkContainer to="/api/prod/Seeds">
          <ListGroupItem tag="a" href="#!" action>
            Seeds
          </ListGroupItem>
        </LinkContainer>

        <LinkContainer to="/api/prod/Fertilizers">
          <ListGroupItem tag="a" href="#!" action>
            Fertilizers
          </ListGroupItem>
        </LinkContainer>

        <LinkContainer to="/api/prod/Machineries">
          <ListGroupItem tag="a" href="#!" action>
            Machineries
          </ListGroupItem>
        </LinkContainer>
      </ListGroup>
    </div>
  )
}

export default Menus
