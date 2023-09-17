import React from 'react'
import { Container, Row, Col } from 'react-bootstrap'
import Carousel from 'react-bootstrap/Carousel'

const carousel = () => {
  return (
    <Container fluid>
      <Row>
        <Col>
          <Carousel>
            <Carousel.Item>
              <img
                src="/images/carousels/carousel img 4.png"
                className="d-block w-100"
              />
            </Carousel.Item>
            <Carousel.Item>
              <img
                src="/images/carousels/carousel img 2.jpg"
                className="d-block w-100"
              />
            </Carousel.Item>
            <Carousel.Item>
              <img
                src="/images/carousels/carousel img 3.jpg"
                className="d-block w-100"
              />
            </Carousel.Item>
          </Carousel>
        </Col>
      </Row>
    </Container>
  )
}

export default carousel
