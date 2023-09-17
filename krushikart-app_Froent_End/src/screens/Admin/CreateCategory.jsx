import React, { useEffect, useState } from 'react'
import AdminMenus from './AdminMenus'
import base_url from '../../api/bootapi'
import httpClient from '../../http-common'
import { useAuth } from '../../context/auth'
import toast from 'react-hot-toast'
import { Modal } from 'antd'

const CreateCategory = () => {
  const [categories, setCategories] = useState([])
  const [categoryName, setName] = useState('')
  const [categoryDesc, setDesc] = useState('')
  const [activeStatus, setStatus] = useState('')
  // const [file, setFile] = useState()
  // const [imageUrl, setImgUrl] = useState('')
  const [imageUrl, setPhoto] = useState('')
  const [visible, setVisible] = useState(false)
  const [selected, setSelected] = useState(null)

  const [updatedcategoryName, setUpdatedName] = useState('')
  const [updatedcategoryDesc, setUpdatedDesc] = useState('')
  const [updatedactiveStatus, setUpdatedStatus] = useState('')
  const [updatedimageUrl, setUpdatedImgUrl] = useState('')

  // function handleChange(e) {
  //   console.log(e.target.files)
  //   setImgUrl = setFile(URL.createObjectURL(e.target.files[0]))
  // }

  //handle Form
  const handleSubmit = async (e) => {
    e.preventDefault()
    const img = imageUrl.name
    try {
      const res = await httpClient.post('/api/category/add', {
        categoryName,
        categoryDesc,
        activeStatus,
        img,
      })
      if (res.status === 200) {
        toast.success(`${categoryName} is created`)
        getAllCategory()
      } else {
        toast.error(res.message)
      }
    } catch (error) {
      console.log(error)
      // toast.error("somthing went wrong in input form");
    }
    console.log(imageUrl.name)
  }

  const getAllCategory = async () => {
    try {
      const { data } = await httpClient.get(`${base_url}/api/category/view`)
      setCategories(data)
    } catch (error) {
      console.log(error)
    }
  }

  useEffect(() => {
    getAllCategory()
  }, [])

  // update category
  const handleUpdate = async (e) => {
    console.log(`for update :  + ${selected.id}`)
    e.preventDefault()
    try {
      const res = await httpClient.put(`/api/category/update`, {
        categoryName: updatedcategoryName,
        categoryDesc: updatedcategoryDesc,
        activeStatus: updatedactiveStatus,
        imageUrl: updatedimageUrl,
      })

      if (res.status === 200) {
        toast.success(`${updatedcategoryName} is updated`)
        setSelected(null)
        setUpdatedName('')
        setVisible(false)
        getAllCategory()
      } else {
        toast.error(res.message)
      }
    } catch (error) {
      console.log(error)
    }
  }

  // delete category
  const handleDelete = async (pId) => {
    try {
      const res = await httpClient.delete(`/api/category/${pId}`)
      if (res.status === 200) {
        toast.success(`category is deleted`)
        getAllCategory()
      } else {
        toast.error(res.message)
      }
    } catch (error) {
      toast.error('Somtihing went wrong')
    }
    console.log(pId)
  }

  return (
    <div className="container-fluid m-3 p-3 dashboard">
      <div className="row">
        <div className="col-md-3">
          <AdminMenus />
        </div>
        <div className="col-md-9">
          <h1>Manage Category</h1>
          <div className="p-3 w-50">
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter new category"
                  value={categoryName}
                  onChange={(e) => setName(e.target.value)}
                />
              </div>
              <div className="mb-3">
                <textarea
                  className="form-control"
                  placeholder="Enter new categoryDesc"
                  value={categoryDesc}
                  onChange={(e) => setDesc(e.target.value)}
                />
              </div>

              <div className="mb-3">
                <div class="form-group">
                  <label for="sel1">Acive Status</label>
                  {/* <select
                    class="form-control"
                    id="sel1"
                    value={activeStatus}
                    onChange={(e) => setStatus(e.target.value)}
                  >
                    <option value="true">True</option>
                    <option value="false">False</option>
                  </select> */}

                  <select
                    className="form-select"
                    aria-label="Default select example"
                    value={activeStatus}
                    onChange={(e) => setStatus(e.target.value)}
                  >
                    <option defaultValue>Select Active status</option>
                    <option value="true">True</option>
                    <option value="false">False</option>
                  </select>
                </div>
              </div>

              <div className="mb-3">
                {/* <label htmlFor="formFile" className="form-label">
                  Default file input example
                </label> */}
                {/* <input
                  className="form-control"
                  type="file"
                  id="formFile"
                  value={imageUrl}
                  onChange={(e) => setImgurl(e.target.value)}
                /> */}
                {/* <div className="App">
                  <h2>Add Image:</h2>
                  <input type="file" onChange={handleChange} />
                  <img src={file} />
                </div> */}

                <label className="btn btn-outline-secondary col-md-12">
                  {imageUrl ? imageUrl.name : 'Upload Photo'}
                  <input
                    type="file"
                    name="photo"
                    accept="image/*"
                    onChange={(e) => setPhoto(e.target.files[0])}
                    hidden
                  />
                </label>
              </div>
              <div className="mb-3">
                {imageUrl && (
                  <div className="text-center">
                    <img
                      src={URL.createObjectURL(imageUrl)}
                      alt="product_photo"
                      height={'200px'}
                      className="img img-responsive"
                    />
                  </div>
                )}
              </div>

              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </form>
          </div>
          <div className="w-75">
            <table className="table">
              <thead>
                <tr>
                  <th scope="col">Name</th>
                  <th scope="col">Actions</th>
                </tr>
              </thead>
              <tbody>
                {categories?.map((c) => (
                  <>
                    <tr>
                      <td key={c.id}>{c.categoryName}</td>
                      <td>
                        <button
                          className="btn btn-primary ms-2"
                          onClick={() => {
                            setVisible(true)
                            setUpdatedName(c.categoryName)
                            setUpdatedDesc(c.categoryDesc)
                            setUpdatedStatus(c.activeStatus)
                            setUpdatedImgUrl(c.setPhoto)
                            setSelected(c)
                          }}
                        >
                          Edit
                        </button>
                        <button
                          className="btn btn-danger ms-2"
                          onClick={() => {
                            handleDelete(c.id)
                          }}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  </>
                ))}
              </tbody>
            </table>
          </div>

          {/* ========================================================================= */}
          <Modal
            onCancel={() => setVisible(false)}
            footer={null}
            visible={visible}
          >
            {/* <CategoryForm
              value={updatedName}
              setValue={setUpdatedName}
              handleSubmit={handleUpdate}
            /> */}
            <form onSubmit={handleUpdate}>
              <div className="mb-3">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter new category"
                  value={updatedcategoryName}
                  onChange={(e) => setUpdatedName(e.target.value)}
                />
              </div>
              <div className="mb-3">
                <textarea
                  className="form-control"
                  placeholder="Enter new categoryDesc"
                  value={updatedcategoryDesc}
                  onChange={(e) => setUpdatedDesc(e.target.value)}
                />
              </div>

              <div className="mb-3">
                <div class="form-group">
                  <select
                    className="form-select"
                    aria-label="Default select example"
                    value={updatedactiveStatus}
                    onChange={(e) => setUpdatedStatus(e.target.value)}
                  >
                    <option defaultValue>Select Active status</option>
                    <option value="true">True</option>
                    <option value="false">False</option>
                  </select>
                </div>
              </div>

              <div className="mb-3">
                <label className="btn btn-outline-secondary col-md-12">
                  {imageUrl ? imageUrl.name : 'Upload Photo'}
                  <input
                    type="file"
                    name="photo"
                    accept="image/*"
                    onChange={(e) => setPhoto(e.target.files[0])}
                    hidden
                  />
                </label>
              </div>
              <div className="mb-3">
                {imageUrl && (
                  <div className="text-center">
                    <img
                      src={URL.createObjectURL(imageUrl)}
                      alt="product_photo"
                      height={'200px'}
                      className="img img-responsive"
                    />
                  </div>
                )}
              </div>

              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </form>
          </Modal>
          {/* ============================================================================= */}
        </div>
      </div>
    </div>
  )
}

export default CreateCategory
